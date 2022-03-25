package com.egao.cloudgateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 登录接口
 *
 * @author Jiuha
 */
@RestController
public class LoginController {

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/login")
    public ResponseEntity<?> login(String username , String password){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(){
        return ResponseEntity.ok().build();
    }
}
