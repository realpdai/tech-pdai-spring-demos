package tech.pdai.test.oom.controller;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is for oom controller.
 */
@RestController
public class TestOomController {

    @GetMapping("oom")
    public String testOom() {
        List<String> list = new ArrayList<>();
        boolean loop = true;
        while (loop) {
            list.add("1");
        }
        return "ok";
    }

    @GetMapping("oom1")
    public String testOom1() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            Map<String, Object> map = new HashMap<>();
            for (int j = 0; j < i; j++) {
                map.put(String.valueOf(j), j);
            }
            mapList.add(map);
        }
        return "ok";
    }

    @GetMapping("oom2")
    public String testOom2() {
        boolean loop = true;
        while (loop) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(TestOomController.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o, objects);
                }
            });
            enhancer.create();
        }
        return "ok";
    }
}
