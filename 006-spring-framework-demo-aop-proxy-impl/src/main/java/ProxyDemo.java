import tech.pdai.springframework.proxy.UserLogProxy;
import tech.pdai.springframework.service.IUserService;
import tech.pdai.springframework.service.UserServiceImpl;

/**
 * This class is for proxy demo interface.
 *
 * @author pdai
 */
public class ProxyDemo {

    /**
     * main interface.
     *
     * @param args args
     */
    public static void main(String[] args) {
        // proxy
        IUserService userService = new UserLogProxy(new UserServiceImpl()).getLoggingProxy();

        // call methods
        userService.findUserList();
        userService.addUser();
    }
}
