package com.egao.cloudserviceuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 *
 * @author Jiuha
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class CloudServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceUserApplication.class, args);
    }

}
