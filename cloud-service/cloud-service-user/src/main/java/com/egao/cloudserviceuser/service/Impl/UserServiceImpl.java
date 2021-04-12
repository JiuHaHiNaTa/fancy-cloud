package com.egao.cloudserviceuser.service.Impl;

import com.egao.cloudserviceuser.entity.User;
import com.egao.cloudserviceuser.mapper.UserMapper;
import com.egao.cloudserviceuser.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @HystrixCommand(fallbackMethod = "userLoginFallBack",threadPoolKey = "user-pool")
    @Override
    public ResponseEntity<User> userLogin(String username, String password) {
        Optional<User> userOptional = mapper.findByUsername(username);
        return userOptional.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @Override
    public ResponseEntity<User> findUserById(String id) {
        Optional<User> userOptional = mapper.findById(id);
        return userOptional.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @Override
    public ResponseEntity<User> userLoginFallBack(String username, String password) {
        return ResponseEntity.badRequest().body(null);
    }


}
