package pdai.tech.opcua.milo;

import java.security.Security;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.eclipse.milo.opcua.stack.core.util.NonceUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * main class.
 *
 * @author pdai
 */
@SpringBootApplication
public class App {

    /**
     * main interface.
     *
     * @param args args
     */
    public static void main(String[] args) {
        try {
            // Required for SecurityPolicy.Aes256_Sha256_RsaPss
            Security.addProvider(new BouncyCastleProvider());
            NonceUtil.blockUntilSecureRandomSeeded(10, TimeUnit.SECONDS);
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            // run app
            SpringApplication.run(App.class, args);
        }
    }

}
