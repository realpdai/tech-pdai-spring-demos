package pdai.tech.opcua.milo.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.eclipse.milo.opcua.sdk.client.api.identity.AnonymousProvider;
import org.eclipse.milo.opcua.sdk.client.api.identity.IdentityProvider;

/**
 * OpcUa client configuration.
 *
 * @author pdai
 */
@Data
@Accessors(chain = true)
public class OpcUaClientConfig {

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
     * identity provider.
     */
    private IdentityProvider identityProvider = new AnonymousProvider();

}
