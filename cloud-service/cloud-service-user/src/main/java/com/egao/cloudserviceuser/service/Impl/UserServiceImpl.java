package com.egao.cloudserviceuser.service.Impl;

import com.egao.cloudserviceapiauth.feign.AuthFeignClient;
import com.egao.cloudserviceuser.entity.User;
import com.egao.cloudserviceuser.mapper.UserMapper;
import com.egao.cloudserviceuser.mapper.UserRoleMapper;
import com.egao.cloudserviceuser.service.UserService;
import com.egao.cloudserviceuser.vo.RegisterVO;
import com.google.common.collect.Maps;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * 用户服务实现类
 *
 * @author Jiuha
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mapper;

    @Resource
    private AuthFeignClient authFeignClient;

    @Override
    public ResponseEntity<OAuth2AccessToken> userLogin(String username, String password) {
        //TODO 代码优化 优化服务调用中使用Map作为参数调用
        //TODO 1、优化魔法值
        //TODO 2、优化Map 成固定的DTO结构哦
        Map<String,String> params = Maps.newHashMap();
        params.put("grant_type" , "password");
        params.put("scope" , "all");
        params.put("username" ,username);
        params.put("password" ,password);
        params.put("client_id" ,"fancycloud");
        params.put("client_secret" ,"123456");
        return authFeignClient.findTokenInfo(params);
    }

    @Override
    public ResponseEntity<User> userRegister(RegisterVO vo) {
        //用户名重复校验
        //添加用户校验
        //添加用户角色关联关系（一般用户）
        User user = new User(vo.getUsername(), vo.getPassword(), vo.getNickname());
        user = mapper.save(user);
        if (Objects.nonNull(user)){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<User> findUserById(String id) {
        Optional<User> userOptional = mapper.findById(id);
        return userOptional.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }



}
