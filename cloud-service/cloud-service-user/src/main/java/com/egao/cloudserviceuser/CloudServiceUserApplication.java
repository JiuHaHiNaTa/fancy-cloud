package com.egao.cloudserviceuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 启动类
 *
 * @author Jiuha
 */
@RefreshScope
@SpringBootApplication(scanBasePackages = "com.egao")
@EnableFeignClients(basePackages = "com.egao.cloudserviceapiauth")
@EnableEurekaClient
//@EnableCircuitBreaker
@EnableResourceServer
public class CloudServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceUserApplication.class, args);
    }

}
