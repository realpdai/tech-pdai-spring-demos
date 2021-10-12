package tech.pdai.ratelimit.guava;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import tech.pdai.ratelimit.guava.config.response.ResponseResult;

/**
 * main class.
 *
 * @author pdai
 */
@Slf4j
@SpringBootApplication
public class App {

    /**
     * main interface.
     *
     * @param args args
     */
    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://localhost:8080/limit1", ResponseResult.class);

        Thread.sleep(1000);

        // test
        test(20);
    }

    @SneakyThrows
    public static void test(int clientSize) {
        CountDownLatch downLatch = new CountDownLatch(clientSize);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(clientSize);
        IntStream.range(0, clientSize).forEach(i ->
                fixedThreadPool.submit(() -> {
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getForObject("http://localhost:8080/limit1", ResponseResult.class);
                    downLatch.countDown();
                })
        );
        downLatch.await();
        fixedThreadPool.shutdown();
    }

}
