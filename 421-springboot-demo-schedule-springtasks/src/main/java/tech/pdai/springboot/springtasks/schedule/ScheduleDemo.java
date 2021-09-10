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
    public void notifyCoinChanges() {
        log.info("current DateTime, {}", LocalDateTime.now());
    }

    /**
     * 每个整点小时执行一次。
     */
    @Scheduled(cron = "0 0 */1 * * ?")
    public void initPolicyList() {
        log.info("current DateTime, {}", LocalDateTime.now());
    }

}
