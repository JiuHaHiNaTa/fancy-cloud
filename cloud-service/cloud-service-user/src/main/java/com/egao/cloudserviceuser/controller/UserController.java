package com.egao.cloudserviceuser.controller;

import com.egao.cloudserviceuser.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户相关接口
 *
 * @author Jiuha
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> login(String username, String password) {
        return userService.userLogin(username, password);
    }
}
