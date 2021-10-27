package tech.pdai.springboot.springtasks.schedule;

import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author pdai
 */
@Slf4j
@EnableScheduling
@Configuration
public class ScheduleDemo {

    /**
     * 每隔1分钟执行一次。
     */
    @Scheduled(fixedRate = 1000 * 60 * 1)
    public void runScheduleFixedRate() {
        log.info("runScheduleFixedRate: current DateTime, {}", LocalDateTime.now());
    }

    /**
     * 每隔1分钟执行一次, 测试异常。
     */
    @Scheduled(fixedRate = 1000 * 60 * 1)
    public void runScheduleFixedRateException() throws Exception {
        log.info("runScheduleFixedRateException: current DateTime, {}", LocalDateTime.now());
        throw new Exception("Error");
    }

    /**
     * 每隔5s执行一次, 测试异常。
     */
    @Scheduled(cron = "*/5 * * * * ?")
    public void runScheduleFixedRateException2() {
        log.info("runScheduleFixedRateException2: current DateTime, {}", LocalDateTime.now());
        int a = 1 / 0;
    }

    /**
     * 每个整点小时执行一次。
     */
    @Scheduled(cron = "0 0 */1 * * ?")
    public void runScheduleCron() {
        log.info("runScheduleCron: current DateTime, {}", LocalDateTime.now());
    }

}
