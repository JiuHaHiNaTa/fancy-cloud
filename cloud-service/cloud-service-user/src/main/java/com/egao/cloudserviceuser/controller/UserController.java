package com.egao.cloudserviceuser.controller;

import com.egao.cloudserviceuser.entity.User;
import com.egao.cloudserviceuser.service.UserService;
import com.egao.cloudserviceuser.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户相关接口
 *
 * @author Jiuha
 */
@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${user.name}")
    private String username;

    @Resource
    private UserService userService;


    @GetMapping("/info")
    public ResponseEntity<User> findUserInfo(String id) {
        return userService.findUserById(id);
    }

    @PreAuthorize("hasAuthority('QUERY_USER_CURRENT')")
    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/hello")
    public String hello(){
        return username;
    }
}
