package com.egao.cloudserviceuser.controller;

import com.egao.cloudserviceuser.entity.User;
import com.egao.cloudserviceuser.service.UserService;
import com.egao.cloudserviceuser.vo.RegisterVO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 登录注册相关接口
 *
 * @author Jiuha
 */
@RestController
public class LoginController {

    @Resource
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<OAuth2AccessToken> login(String username, String password) {
        return userService.userLogin(username, password);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(RegisterVO registerVO) {
        return userService.userRegister(registerVO);
    }
}
