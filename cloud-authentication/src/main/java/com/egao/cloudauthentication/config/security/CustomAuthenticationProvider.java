package com.egao.cloudauthentication.config.security;

import com.egao.cloudauthentication.entity.User;
import com.egao.cloudauthentication.service.AuthenticationUserDetailServiceImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 自定义认证
 *
 * @author Jiuha
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private AuthenticationUserDetailServiceImpl userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        if (userDetails == null) {
            throw new BadCredentialsException("用户名不存在");
        }
        if (!password.equals(userDetails.getPassword())) {
            throw new BadCredentialsException("密码错误");
        }
        assert userDetails.isAccountNonExpired() : "用户认证已过期";
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
