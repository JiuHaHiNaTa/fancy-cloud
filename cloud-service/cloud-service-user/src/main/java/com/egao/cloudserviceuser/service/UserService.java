package com.egao.cloudserviceuser.service;

import com.egao.cloudserviceuser.entity.User;
import com.egao.cloudserviceuser.vo.RegisterVO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

/**
 * 用户服务接口
 *
 * @author Jiuha
 */
@Service
public interface UserService {

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回统一响应格式
     */
    ResponseEntity<OAuth2AccessToken> userLogin(String username, String password);

    /**
     * 用户注册
     *
     * @param vo 前端返回注册VO类
     * @return 返回部分用户信息（暂定）
     */
    ResponseEntity<User> userRegister(RegisterVO vo);

    /**
     * 根据用户主键ID查询用户
     * @param id 用户主键ID
     * @return 返回统一响应格式
     */
    ResponseEntity<User> findUserById(String id);



}
