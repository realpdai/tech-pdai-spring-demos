package tech.pdai.springframework;

import tech.pdai.springframework.proxy.UserLogProxy;
import tech.pdai.springframework.service.UserServiceImpl;

/**
 * Cglib proxy demo.
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
        UserServiceImpl userService = (UserServiceImpl) new UserLogProxy().getUserLogProxy(new UserServiceImpl());

        // call methods
        userService.findUserList();
        userService.addUser();
    }
}
