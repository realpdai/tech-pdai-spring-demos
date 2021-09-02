package pdai.tech.opcua.milo.config;

import java.security.KeyPair;
import java.security.cert.X509Certificate;

import lombok.Data;
import org.eclipse.milo.opcua.stack.client.security.ClientCertificateValidator;

/**
 * @author pdai
 */
@Data
public class OpcUaSSLConfig {

    /**
     * certificate chain.
     */
    private X509Certificate[] certificateChain;

    /**
     * certificate.
     */
    private X509Certificate certificate;

    /**
     * key pair.
     */
    private KeyPair clientKeyPair;

    /**
     * certificate validator.
     */
    private ClientCertificateValidator certificateValidator;
}
