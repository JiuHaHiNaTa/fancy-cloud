package com.egao.cloudserviceuser.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * 用户服务接口
 *
 * @author Jiuha
 */
@Service
public interface UserService {

    /**
     * 用户登录名
     * @param username 用户名
     * @param password 密码
     * @return 返回统一响应格式
     */
    ResponseEntity<?> userLogin(String username, String password);
}
