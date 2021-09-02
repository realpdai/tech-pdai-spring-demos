package pdai.tech.opcua.milo.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.milo.opcua.binaryschema.GenericBsdParser;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.dtd.DataTypeDictionarySessionInitializer;
import org.eclipse.milo.opcua.sdk.client.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.client.security.DefaultClientCertificateValidator;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.security.DefaultTrustListManager;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExtensionObject;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryData;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryReadResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryReadResult;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryReadValueId;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadRawModifiedDetails;
import org.springframework.stereotype.Service;
import pdai.tech.opcua.milo.config.OpcUaClientConfig;
import pdai.tech.opcua.milo.config.OpcUaSSLConfig;
import pdai.tech.opcua.milo.entity.CustomStructType;
import pdai.tech.opcua.milo.properties.OpcUaProperties;
import pdai.tech.opcua.milo.service.impl.IOpcUaService;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;
import static org.eclipse.milo.opcua.stack.core.util.ConversionUtil.l;

/**
 * opc ua service impl.
 *
 * @author pdai
 */
@Slf4j
@Service
public class OpcUaClientServiceImpl implements IOpcUaService {

    /**
     * opc-ua properties.
     */
    private final OpcUaProperties opcUaProperties;

    /**
     * opc-ua client.
     */
    private volatile OpcUaClient client;

    /**
     * init.
     *
     * @param opcUaProperties opc-ua properties
     */
    public OpcUaClientServiceImpl(OpcUaProperties opcUaProperties) {
        this.opcUaProperties = opcUaProperties;
    }

    /**
     * get client.
     *
     * @return opc-ua client
     * @throws java.security.UnrecoverableKeyException       UnrecoverableKey Exception
     * @throws org.eclipse.milo.opcua.stack.core.UaException UaException
     * @throws java.security.cert.CertificateException       Certificate Exception
     * @throws java.io.IOException                           IOException
     * @throws java.security.KeyStoreException               KeyStore Exception
     * @throws java.security.NoSuchAlgorithmException        No Such Algorithm Exception
     */
    private OpcUaClient getOpcUaClient() throws UnrecoverableKeyException, UaException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException {
        if (client==null) {
            synchronized (OpcUaClient.class) {
                if (client==null) {
                    client = createClient();
                }
            }
        }
        return client;
    }

    /**
     * get security policy.
     *
     * @param policyName policy name
     * @return SecurityPolicy
     */
    private SecurityPolicy getSelectPolicy(String policyName) {
        try {
            return SecurityPolicy.fromUri("http://opcfoundation.org/UA/SecurityPolicy#" + policyName);
        } catch (UaException e) {
            log.error("parse security policy error, name = {}", policyName);
            e.printStackTrace();
        }
        return SecurityPolicy.None;
    }

    /**
     * get opc-ua client.
     *
     * @return client
     */
    private OpcUaClient createClient() throws UaException, IOException, UnrecoverableKeyException, CertificateException, KeyStoreException, NoSuchAlgorithmException {
        OpcUaClientConfig clientConfig = initOpcUaClientConfig(opcUaProperties);

        // ssl config
        if (opcUaProperties.isEnableSSL()) {
            OpcUaSSLConfig sslConfig = getOpcUaClientSSLConfig(opcUaProperties);
            return OpcUaClient.create(clientConfig.getEndpointUrl(),
                    endpoints -> endpoints.stream().filter(e -> getSelectPolicy(opcUaProperties.getSecurityPolicy()).getUri()
                            .equals(e.getSecurityPolicyUri())).findFirst(),
                    opcUaClientConfigBuilder -> opcUaClientConfigBuilder.setApplicationName(LocalizedText.english(clientConfig.getApplicationName()))
                            .setApplicationUri(clientConfig.getApplicationUri())
                            .setIdentityProvider(clientConfig.getIdentityProvider())
                            .setKeyPair(sslConfig.getClientKeyPair())
                            .setCertificate(sslConfig.getCertificate())
                            .setCertificateChain(sslConfig.getCertificateChain())
                            .setCertificateValidator(sslConfig.getCertificateValidator())
                            .setRequestTimeout(uint(clientConfig.getRequestTimeOut())).build());
        } else {
            return OpcUaClient.create(clientConfig.getEndpointUrl(),
                    endpoints -> endpoints.stream().filter(e -> SecurityPolicy.None.getUri().equals(e.getSecurityPolicyUri())).findFirst(),
                    opcUaClientConfigBuilder -> opcUaClientConfigBuilder.setApplicationName(LocalizedText.english(clientConfig.getApplicationName()))
                            .setApplicationUri(clientConfig.getApplicationUri())
                            .setIdentityProvider(clientConfig.getIdentityProvider())
                            .setRequestTimeout(uint(clientConfig.getRequestTimeOut())).build());
        }
    }

    /**
     * get opc ua client config.
     *
     * @param opcUaProperties opcUa properties
     * @return OpcUaClientConfig
     */
    private OpcUaClientConfig initOpcUaClientConfig(OpcUaProperties opcUaProperties) {
        return new OpcUaClientConfig()
                .setApplicationName(opcUaProperties.getClient().getApplicationName())
                .setApplicationUri(opcUaProperties.getClient().getApplicationUri())
                .setEndpointUrl(opcUaProperties.getClient().getEndpointUrl())
                .setRequestTimeOut(opcUaProperties.getClient().getRequestTimeOut());
    }

    /**
     * @param opcUaProperties opcUaProperties
     * @return ssl client config
     * @throws java.security.KeyStoreException         KeyStore Exception
     * @throws java.io.IOException                     IO Exception
     * @throws java.security.cert.CertificateException Certificate Exception
     * @throws java.security.NoSuchAlgorithmException  NoSuchAlgorithm Exception
     * @throws java.security.UnrecoverableKeyException UnrecoverableKey Exception
     */
    private OpcUaSSLConfig getOpcUaClientSSLConfig(OpcUaProperties opcUaProperties) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        OpcUaSSLConfig sslConfig = new OpcUaSSLConfig();

        // load keys from security dir
        Path securityTempDir = Paths.get(System.getProperty("java.io.tmpdir"), "client", "security");
        Files.createDirectories(securityTempDir);
        if (!Files.exists(securityTempDir)) {
            log.error("unable to create security dir: " + securityTempDir);
        }
        File pkiDir = securityTempDir.resolve("pki").toFile();

        log.info("security dir: {}", securityTempDir.toAbsolutePath());
        log.info("security pki dir: {}", pkiDir.getAbsolutePath());

        KeyStore keyStore = KeyStore.getInstance(opcUaProperties.getClient().getSslCertificateType());

        Path serverKeyStore = securityTempDir.resolve(opcUaProperties.getClient().getSslCertificateFile());

        log.info("Loading KeyStore at {}", serverKeyStore);

        try (InputStream in = Files.newInputStream(serverKeyStore)) {
            keyStore.load(in, opcUaProperties.getClient().getSslCertificatePwd().toCharArray());
        }

        // setup certificate
        Key clientPrivateKey = keyStore.getKey(opcUaProperties.getClient().getSslCertificateAlias(), opcUaProperties.getClient().getSslCertificatePwd().toCharArray());
        if (clientPrivateKey instanceof PrivateKey) {
            sslConfig.setCertificate((X509Certificate) keyStore.getCertificate(opcUaProperties.getClient().getSslCertificateAlias()));
            sslConfig.setCertificateChain(Arrays.stream(keyStore.getCertificateChain(opcUaProperties.getClient().getSslCertificateAlias()))
                    .map(X509Certificate.class::cast)
                    .toArray(X509Certificate[]::new));
            PublicKey serverPublicKey = sslConfig.getCertificate().getPublicKey();
            sslConfig.setClientKeyPair(new KeyPair(serverPublicKey, (PrivateKey) clientPrivateKey));
        }

        // client validator
        DefaultTrustListManager trustListManager = new DefaultTrustListManager(pkiDir);
        sslConfig.setCertificateValidator(new DefaultClientCertificateValidator(trustListManager));

        return sslConfig;
    }

    /**
     * retrieve data.
     *
     * @param nodeId nodeId
     * @param maxAge maxAge
     * @return data value
     * @throws java.security.UnrecoverableKeyException UnrecoverableKey Exception
     * @throws UaException                             Ua Exception
     * @throws java.security.cert.CertificateException Certificate Exception
     * @throws java.io.IOException                     IO Exception
     * @throws java.security.KeyStoreException         KeyStore Exception
     * @throws java.security.NoSuchAlgorithmException  NoSuchAlgorithm Exception
     * @throws java.util.concurrent.ExecutionException Execution Exception
     * @throws InterruptedException                    Interrupted Exception
     */
    @Override
    public DataValue retrieveGenericData(NodeId nodeId, double maxAge) throws UnrecoverableKeyException,
            UaException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException,
            ExecutionException, InterruptedException {
        OpcUaClient opcClient = getOpcUaClient();
        try {
            opcClient.addSessionInitializer(new DataTypeDictionarySessionInitializer(new GenericBsdParser()));
            opcClient.connect().get();
            return opcClient.readValue(maxAge, TimestampsToReturn.Both, nodeId).get();
        } finally {
            opcClient.disconnect();
        }
    }

    /**
     * retrieve multiple data.
     *
     * @param nodeIds nodeIds
     * @param maxAge  maxAge
     * @return data value
     * @throws java.security.UnrecoverableKeyException UnrecoverableKey Exception
     * @throws UaException                             Ua Exception
     * @throws java.security.cert.CertificateException Certificate Exception
     * @throws java.io.IOException                     IO Exception
     * @throws java.security.KeyStoreException         KeyStore Exception
     * @throws java.security.NoSuchAlgorithmException  NoSuchAlgorithm Exception
     * @throws java.util.concurrent.ExecutionException Execution Exception
     * @throws InterruptedException                    Interrupted Exception
     */
    @Override
    public List<DataValue> retrieveGenericDataList(List<NodeId> nodeIds, double maxAge) throws UnrecoverableKeyException,
            UaException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException,
            ExecutionException, InterruptedException {
        OpcUaClient opcClient = getOpcUaClient();
        try {
            opcClient.addSessionInitializer(new DataTypeDictionarySessionInitializer(new GenericBsdParser()));
            opcClient.connect().get();
            return opcClient.readValues(maxAge, TimestampsToReturn.Both, nodeIds).get();
        } finally {
            opcClient.disconnect();
        }
    }

    /**
     * retrieve history data.
     *
     * @param historyReadValueId historyReadValueId
     * @return history data value
     * @throws java.security.UnrecoverableKeyException UnrecoverableKey Exception
     * @throws UaException                             Ua Exception
     * @throws java.security.cert.CertificateException Certificate Exception
     * @throws java.io.IOException                     IO Exception
     * @throws java.security.KeyStoreException         KeyStore Exception
     * @throws java.security.NoSuchAlgorithmException  NoSuchAlgorithm Exception
     * @throws java.util.concurrent.ExecutionException Execution Exception
     * @throws InterruptedException                    Interrupted Exception
     */
    @Override
    public List<DataValue> retrieveGenericHistoryData(HistoryReadValueId historyReadValueId) throws UnrecoverableKeyException,
            UaException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException,
            ExecutionException, InterruptedException {
        OpcUaClient opcClient = getOpcUaClient();
        try {
            HistoryReadResponse historyReadResponse = opcClient.historyRead(
                    new ReadRawModifiedDetails(
                            false,
                            DateTime.MIN_VALUE,
                            DateTime.now(),
                            uint(0),
                            true
                    ),
                    TimestampsToReturn.Both,
                    false,
                    Collections.singletonList(historyReadValueId)
            ).get();

            // parse result
            HistoryReadResult[] historyReadResults = historyReadResponse.getResults();

            if (historyReadResults!=null) {
                HistoryReadResult historyReadResult = historyReadResults[0];
                StatusCode statusCode = historyReadResult.getStatusCode();

                if (statusCode.isGood()) {
                    HistoryData historyData = (HistoryData) historyReadResult.getHistoryData().decode(
                            opcClient.getStaticSerializationContext()
                    );
                    return l(historyData.getDataValues());
                } else {
                    log.error("History read failed: {}", statusCode);
                }
            }
            return new ArrayList<>();
        } finally {
            opcClient.disconnect();
        }
    }

    /**
     * retrieve custom type data.
     *
     * @param nodeId node id
     * @return data
     * @throws java.security.UnrecoverableKeyException UnrecoverableKey Exception
     * @throws UaException                             Ua Exception
     * @throws java.security.cert.CertificateException Certificate Exception
     * @throws java.io.IOException                     IO Exception
     * @throws java.security.KeyStoreException         KeyStore Exception
     * @throws java.security.NoSuchAlgorithmException  NoSuchAlgorithm Exception
     * @throws java.util.concurrent.ExecutionException Execution Exception
     * @throws InterruptedException                    Interrupted Exception
     */
    @Override
    public CustomStructType retrieveCustomData(NodeId nodeId) throws UnrecoverableKeyException,
            UaException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException,
            ExecutionException, InterruptedException {
        log.info("trying to get custom data from node {}", nodeId);
        OpcUaClient opcClient = getOpcUaClient();
        try {
            // connect
            log.info("connect to opc server");
            opcClient.addSessionInitializer(new DataTypeDictionarySessionInitializer(new GenericBsdParser()));
            opcClient.connect().get();

            // register custom codec
            log.info("register custom codec");
            registerCustomCodec(opcClient);

            // synchronous read request via VariableNode
            UaVariableNode node = opcClient.getAddressSpace().getVariableNode(nodeId);
            log.info("DataType={}", node.getDataType());

            // Read the current value
            log.info("trying to read value form NodeId");
            DataValue value = node.readValue();
            log.info("Value={}", value);
            Variant variant = value.getValue();
            ExtensionObject xo = (ExtensionObject) variant.getValue();

            // decode value
            CustomStructType decoded = (CustomStructType) xo.decode(opcClient.getStaticSerializationContext());
            log.info("Decoded={}", decoded);

            return decoded;
        } finally {
            opcClient.disconnect();
        }
    }

    /**
     * retrieve custom type history data.
     *
     * @param historyReadValueId node id
     * @return data
     * @throws java.security.UnrecoverableKeyException       UnrecoverableKey Exception
     * @throws org.eclipse.milo.opcua.stack.core.UaException Ua Exception
     * @throws java.security.cert.CertificateException       Certificate Exception
     * @throws java.io.IOException                           IO Exception
     * @throws java.security.KeyStoreException               KeyStore Exception
     * @throws java.security.NoSuchAlgorithmException        NoSuchAlgorithm Exception
     * @throws java.util.concurrent.ExecutionException       Execution Exception
     * @throws InterruptedException                          Interrupted Exception
     */
    @Override
    public List<CustomStructType> retrieveCustomHistoryData(HistoryReadValueId historyReadValueId) throws UnrecoverableKeyException,
            UaException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException,
            ExecutionException, InterruptedException {
        log.info("trying to get custom data from node {}", historyReadValueId);
        OpcUaClient opcClient = getOpcUaClient();
        try {
            // connect
            log.info("connect to opc server");
            opcClient.addSessionInitializer(new DataTypeDictionarySessionInitializer(new GenericBsdParser()));
            opcClient.connect().get();

            // read history
            HistoryReadResponse historyReadResponse = opcClient.historyRead(
                    new ReadRawModifiedDetails(
                            false,
                            DateTime.MIN_VALUE,
                            DateTime.now(),
                            uint(0),
                            true
                    ),
                    TimestampsToReturn.Both,
                    false,
                    Collections.singletonList(historyReadValueId)
            ).get();

            // register custom codec
            log.info("register custom codec");
            registerCustomCodec(opcClient);

            // parse result
            log.info("parse history data result");
            HistoryReadResult[] historyReadResults = historyReadResponse.getResults();
            if (historyReadResults!=null) {
                HistoryReadResult historyReadResult = historyReadResults[0];
                StatusCode statusCode = historyReadResult.getStatusCode();

                // check if status code is good
                if (statusCode.isGood()) {
                    HistoryData historyData = (HistoryData) historyReadResult.getHistoryData().decode(
                            opcClient.getStaticSerializationContext()
                    );

                    // parse node value to custom type
                    return l(historyData.getDataValues()).stream().map(value -> {
                        log.info("Value={}", value);
                        Variant variant = value.getValue();
                        ExtensionObject xo = (ExtensionObject) variant.getValue();

                        // decode value
                        CustomStructType decoded = (CustomStructType) xo.decode(opcClient.getStaticSerializationContext());
                        log.info("Decoded={}", decoded);

                        return decoded;
                    }).collect(Collectors.toList());
                } else {
                    log.error("History read failed: {}", statusCode);
                }
            }
            return new ArrayList<>();
        } finally {
            opcClient.disconnect();
        }
    }

    /**
     * Register codec with the client's DataTypeManager instance.
     * We need to register it by both its encodingId and its dataTypeId because it may be
     * looked up by either depending on the context.
     *
     * @param client client
     */
    private void registerCustomCodec(OpcUaClient client) {

        // register binary encoding id
        NodeId binaryEncodingId = CustomStructType.BINARY_ENCODING_ID
                .toNodeId(client.getNamespaceTable())
                .orElseThrow(() -> new IllegalStateException("namespace not found"));
        client.getStaticDataTypeManager().registerCodec(
                binaryEncodingId,
                new CustomStructType.Codec().asBinaryCodec()
        );

        // register data type id
        NodeId dataTypeId = CustomStructType.TYPE_ID
                .toNodeId(client.getNamespaceTable())
                .orElseThrow(() -> new IllegalStateException("namespace not found"));
        client.getStaticDataTypeManager().registerCodec(
                new QualifiedName(dataTypeId.getNamespaceIndex(), "CustomStructType"),
                dataTypeId,
                new CustomStructType.Codec().asBinaryCodec()
        );
    }

}
