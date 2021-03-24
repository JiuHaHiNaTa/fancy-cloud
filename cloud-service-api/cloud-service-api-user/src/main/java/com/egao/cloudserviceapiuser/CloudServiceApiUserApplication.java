package com.egao.cloudserviceapiuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudServiceApiUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceApiUserApplication.class, args);
    }

}
