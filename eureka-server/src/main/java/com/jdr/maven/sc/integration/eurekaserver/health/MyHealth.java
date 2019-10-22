package com.jdr.maven.sc.integration.eurekaserver.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @author zhoude
 * @date 2019/10/22 19:57
 */
@Component
public class MyHealth extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        System.err.println("这是自定义的健康检查");
        builder.up().status(new Status("UP", "这是具体信息")).build();
    }
}
