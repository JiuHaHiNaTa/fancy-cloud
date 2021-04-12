package com.egao.cloudserviceuser.service;

import com.egao.cloudserviceuser.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回统一响应格式
     */
    ResponseEntity<User> userLogin(String username, String password);

    /**
     * 根据用户主键ID查询用户
     * @param id 用户主键ID
     * @return 返回统一响应格式
     */
    ResponseEntity<User> findUserById(String id);

    /**
     * 用户登录名 - 后备方法
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回统一响应格式
     */
    ResponseEntity<User> userLoginFallBack(String username, String password);


}
