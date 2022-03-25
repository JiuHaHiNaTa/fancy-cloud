package com.egao.cloudauthentication.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 验证所需用户属性
 *
 * @author Jiuha
 */
public class AuthenticationUserDetails implements UserDetails {

    private final transient User user;

    private final transient Set<Permission> permissionSet;

    public AuthenticationUserDetails(User user, Set<Permission> permissionSet) {
        this.user = user;
        this.permissionSet = permissionSet;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissionSet.stream()
                .filter(permission -> permission.getValue() != null)
                .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus().equals(0);
    }
}
