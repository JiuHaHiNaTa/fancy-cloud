package com.egao.cloudauthentication.service;

import com.egao.cloudauthentication.entity.*;
import com.egao.cloudauthentication.mapper.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Spring Security自定义验证用户信息UserDetailsService
 *
 * @author Jiuha
 */
@Component
@Service
public class AuthenticationUserDetailServiceImpl implements UserDetailsService {

    @Resource
    UserMapper userMapper;

    @Resource
    UserRoleMapper userRoleMapper;

    @Resource
    UserPermissionMapper userPermissionMapper;

    @Resource
    RolePermissionMapper rolePermissionMapper;

    @Resource
    PermissionMapper permissionMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = userMapper.findByUsername(username);
        if (userInfo.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        User user = userInfo.get();
        Set<Permission> permissionSet = getPermissionsOfUser(userInfo.get());
        return new AuthenticationUserDetails(user, permissionSet);
    }

    /**
     * 根据用户获取用户拥有的权限集合
     *
     * @param user 用户实体类
     * @return 用户权限集合
     */
    public Set<Permission> getPermissionsOfUser(@NotNull User user) {
        String userId = user.getId();
        UserRole userRole = userRoleMapper.findByUserId(userId);
        String roleId = userRole.getRoleId();
        Set<RolePermission> rolePermissionSet = rolePermissionMapper.findByRoleId(roleId);
        Set<UserPermission> addPermissionSet = userPermissionMapper.findByUserIdAndAndType(userId, 1);
        Set<UserPermission> delPermissionSet = userPermissionMapper.findByUserIdAndAndType(userId, -1);
        Set<String> ids = rolePermissionSet.stream().map(RolePermission::getPermissionId).collect(Collectors.toSet());
        Set<String> addIds = addPermissionSet.stream().map(UserPermission::getPermissionId).collect(Collectors.toSet());
        Set<String> delIds = delPermissionSet.stream().map(UserPermission::getPermissionId).collect(Collectors.toSet());
        Set<Permission> permissions = permissionMapper.findByIdIn(ids);
        Set<Permission> addPermissions = permissionMapper.findByIdIn(addIds);
        Set<Permission> delPermissions = permissionMapper.findByIdIn(delIds);
        //取并集，权限集合
        permissions.addAll(addPermissions);
        //去重
        permissions = permissions.stream().distinct().collect(Collectors.toSet());
        //取集合交集
        permissions = permissions.stream().filter(e -> !delPermissions.contains(e)).collect(Collectors.toSet());
        return permissions;
    }

}
