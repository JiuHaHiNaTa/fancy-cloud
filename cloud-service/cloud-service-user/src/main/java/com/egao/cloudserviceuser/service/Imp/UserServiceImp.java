package com.egao.cloudserviceuser.service.Imp;

import com.egao.cloudserviceuser.entity.User;
import com.egao.cloudserviceuser.mapper.UserMapper;
import com.egao.cloudserviceuser.service.UserService;
import org.springframework.http.HttpStatus;
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
public class UserServiceImp implements UserService {

    @Resource
    private UserMapper mapper;

    @Override
    public ResponseEntity<?> userLogin(String username, String password) {
        Optional<User> userOptional = mapper.findByUsernameAndDeleteFlag(username, 0);
        System.out.println(userOptional.get().toString());
        return userOptional.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }
}
