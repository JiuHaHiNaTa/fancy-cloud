package com.egao.clouddemo2.controller;

import com.egao.clouddemo2.clients.TestFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TestController {

//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/test")
//    public ResponseEntity<String>  test(String id) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("clouddemo");
//        if (instances.size() == 0) {
//            return null;
//        }
//        System.out.println(instances.get(0).getUri().toString());
//        String serviceUri = String.format("%s/hello", instances.get(0).getUri().toString());
//        System.out.println(serviceUri);
//        ResponseEntity<String> responseEntity = restTemplate.exchange(serviceUri, HttpMethod.GET, null, String.class, id);
//        return responseEntity;
//    }

    @Autowired
    TestFeignClient testFeignClient;

    @RequestMapping("/test")
    public String test(String id){
        return testFeignClient.testFeign(id);
    }

}
