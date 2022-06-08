package tech.pdai.springboot.xxljob.job;

import com.xxl.job.core.handler.IJobHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author pdai
 */
@Slf4j
public class BeanClassDemoJob extends IJobHandler {

    @Override
    public void execute() throws Exception {
        log.info("BeanClassDemoJob, execute...");
    }
}
