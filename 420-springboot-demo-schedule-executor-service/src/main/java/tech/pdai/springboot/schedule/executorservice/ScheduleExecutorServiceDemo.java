package tech.pdai.springboot.schedule.executorservice;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author pdai
 */
@Slf4j
public class ScheduleExecutorServiceDemo {


    /**
     * 每秒执行一次，延迟0.5秒执行。
     */
    @SneakyThrows
    public static void scheduleAtFixedRate() {
        AtomicInteger count = new AtomicInteger(0);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    @SneakyThrows
                    public void run() {
                        if (count.getAndIncrement()==2) {
                            Thread.sleep(5000); // 执行时间超过执行周期
                        }
                        log.info("run scheduleAtFixedRate @ {}", LocalDateTime.now());
                    }
                },
                500,
                1000, // 每隔多久执行
                TimeUnit.MILLISECONDS);
        // waiting to process(sleep to mock)
        Thread.sleep(10000);

        // stop
        executor.shutdown();
    }

    /**
     * 每秒执行一次，延迟0.5秒执行。
     */
    @SneakyThrows
    public static void scheduleWithFixedDelay() {
        AtomicInteger count = new AtomicInteger(0);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(
                new Runnable() {
                    @Override
                    @SneakyThrows
                    public void run() {
                        if (count.getAndIncrement()==2) {
                            Thread.sleep(5000); // 执行时间超过执行周期
                        }
                        log.info("run scheduleWithFixedDelay @ {}", LocalDateTime.now());
                    }
                },
                500,
                1000, // 上次执行完成后，延迟多久执行
                TimeUnit.MILLISECONDS);

        // waiting to process(sleep to mock)
        Thread.sleep(10000);

        // stop
        executor.shutdown();
    }

    public static void main(String[] args) {
        scheduleAtFixedRate();

        scheduleWithFixedDelay();
    }
}
