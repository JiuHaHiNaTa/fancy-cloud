package com.egao.cloudauthentication.service;

import com.egao.cloudauthentication.entity.User;
import com.egao.cloudauthentication.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Spring Security自定义验证用户信息UserDetailsService
 *
 * @author Jiuha
 */
@Component
public class AuthenticationUserDetailServiceImpl implements UserDetailsService {

    @Resource
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = userMapper.findByUsername(username);
        if (userInfo.isEmpty()){
            return null;
        }
        return null;
    }
}
