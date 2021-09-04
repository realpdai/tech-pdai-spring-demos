package tech.pdai.opcua.milo.client.service.impl;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryReadValueId;
import tech.pdai.opcua.milo.client.entity.CustomStructType;

/**
 * opc ua service.
 *
 * @author pdai
 */
public interface IOpcUaService {

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
    DataValue retrieveGenericData(NodeId nodeId, double maxAge) throws UnrecoverableKeyException,
            UaException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException,
            ExecutionException, InterruptedException;

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
    List<DataValue> retrieveGenericDataList(List<NodeId> nodeIds, double maxAge) throws UnrecoverableKeyException,
            UaException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException,
            ExecutionException, InterruptedException;

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
    List<DataValue> retrieveGenericHistoryData(HistoryReadValueId historyReadValueId) throws UnrecoverableKeyException,
            UaException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException,
            ExecutionException, InterruptedException;

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
    CustomStructType retrieveCustomData(NodeId nodeId) throws UnrecoverableKeyException,
            UaException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException,
            ExecutionException, InterruptedException;

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
    List<CustomStructType> retrieveCustomHistoryData(HistoryReadValueId historyReadValueId) throws UnrecoverableKeyException,
            UaException, CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException,
            ExecutionException, InterruptedException;

}
