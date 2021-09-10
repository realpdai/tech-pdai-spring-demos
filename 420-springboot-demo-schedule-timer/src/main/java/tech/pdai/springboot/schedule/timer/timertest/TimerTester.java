package tech.pdai.springboot.schedule.timer.timertest;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author pdai
 */
@Slf4j
public class TimerTester {

    @SneakyThrows
    public static void timer() {
        // start timer
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                log.info("timer-task @{}", LocalDateTime.now());
            }
        }, 1000);

        // waiting to process(sleep to mock)
        Thread.sleep(3000);

        // stop timer
        timer.cancel();
    }

    @SneakyThrows
    public static void timerPeriod() {
        // start timer
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @SneakyThrows
            public void run() {
                log.info("timer-period-task @{}", LocalDateTime.now());
                Thread.sleep(100); // 执行时间大于Period间隔时间
            }
        }, 500, 1000);

        // waiting to process(sleep to mock)
        Thread.sleep(10000);

        // stop timer
        timer.cancel();
    }

    @SneakyThrows
    public static void timerFixedRate() {
        // start timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int count = 0;

            @SneakyThrows
            public void run() {
                if (count++==2) {
                    Thread.sleep(5000); // 某一次执行时间超过了period(执行周期）
                }
                log.info("timer-fixedRate-task @{}", LocalDateTime.now());

            }
        }, 500, 1000);

        // waiting to process(sleep to mock)
        Thread.sleep(10000);

        // stop timer
        timer.cancel();
    }


    public static void main(String[] args) {
        timer();
        timerPeriod();
        timerFixedRate();
    }
}
