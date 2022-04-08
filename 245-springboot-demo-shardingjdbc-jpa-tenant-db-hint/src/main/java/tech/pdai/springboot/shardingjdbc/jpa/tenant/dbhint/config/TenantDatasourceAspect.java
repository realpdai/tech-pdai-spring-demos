package tech.pdai.springboot.shardingjdbc.jpa.tenant.dbhint.config;

import org.apache.shardingsphere.api.hint.HintManager;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author pdai
 */
@Aspect
@Order(1)
@Component
public class TenantDatasourceAspect {

    /**
     * point cut.
     */
    @Pointcut("execution(* tech.pdai.springboot.shardingjdbc.jpa.tenant.dbhint.dao.*.*(..))")
    public void useTenantDSPointCut() {
        // no impl
    }

    @Before("useTenantDSPointCut()")
    public void doDs0Before() {
        HintManager.clear();
        HintManager hintManager = HintManager.getInstance();
        // pdai: 实际环境将client信息放在xxxContext中（由ThreadLocal承接），并通过client-id来获取tenant.
        // 这里为了方便演示，只是使用了tenant-a
        hintManager.setDatabaseShardingValue("tenant-a");
    }

    @After("useTenantDSPointCut()")
    public void doDs0after() {
        HintManager.clear();
    }

}

