package tech.pdai.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tech.pdai.springframework.service.CglibProxyDemoServiceImpl;
import tech.pdai.springframework.service.IJdkProxyService;
import tech.pdai.springframework.service.JdkProxyDemoServiceImpl;

/**
 * @author pdai
 */
public class App {

    /**
     * main interfaces.
     *
     * @param args args
     */
    public static void main(String[] args) {
        // create and configure beans
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "tech.pdai.springframework");

        // jdk proxy demo
        IJdkProxyService service2 = context.getBean(IJdkProxyService.class);
        service2.doMethod1();
        service2.doMethod2();
        try {
            service2.doMethod3();
        } catch (Exception e) {
            // e.printStackTrace();
        }

        // cglib proxy demo
        CglibProxyDemoServiceImpl service = context.getBean(CglibProxyDemoServiceImpl.class);
        service.doMethod1();
        service.doMethod2();
        try {
            service.doMethod3();
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }
}
