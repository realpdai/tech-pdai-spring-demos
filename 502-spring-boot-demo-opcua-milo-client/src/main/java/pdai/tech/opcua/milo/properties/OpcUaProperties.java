package pdai.tech.opcua.milo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pdai
 */
@Data
@Component
@ConfigurationProperties(prefix = "config.opcua")
public class OpcUaProperties {

    /**
     * enable ssl.
     */
    private boolean enableSSL = false;

    /**
     * security policy.
     */
    private String securityPolicy;

    /**
     * client properties.
     */
    private OpcUaClientProperties client;

    /**
     * node properties.
     */
    private CustomNode myNode;

    /**
     * opc ua client properties.
     */
    @Data
    public static class OpcUaClientProperties {
        /**
         * application name.
         */
        private String applicationName;

        /**
         * application uri.
         */
        private String applicationUri;

        /**
         * endpoint url.
         */
        private String endpointUrl;

        /**
         * request timeout.
         */
        private long requestTimeOut = 5000;

        /**
         * ssl certificate type.
         */
        private String sslCertificateType;

        /**
         * ssl certificate file.
         */
        private String sslCertificateFile;

        /**
         * ssl certificate alias.
         */
        private String sslCertificateAlias;

        /**
         * ssl certificate pwd.
         */
        private String sslCertificatePwd;

    }

    /**
     * custom node properties.
     */
    @Data
    public static class CustomNode {
        /**
         * namespace index.
         */
        private int namespaceIndex;

        /**
         * identifier.
         */
        private String identifier;

    }

}
