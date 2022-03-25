package com.egao.cloudauthentication;

import com.egao.cloudauthentication.entity.*;
import com.egao.cloudauthentication.mapper.*;
import com.egao.cloudauthentication.service.AuthenticationUserDetailServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class CloudAuthenticationApplicationTests {

    @Resource
    UserMapper userMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    PermissionMapper permissionMapper;

    @Resource
    RolePermissionMapper rolePermissionMapper;

    @Resource
    UserRoleMapper userRoleMapper;

    @Resource
    AuthenticationUserDetailServiceImpl userDetailService;

    @Resource
    UserPermissionMapper userPermissionMapper;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("jiuha");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        user.setNickname("Jiuha");
        user.setStatus(0);

        userMapper.save(user);

//        Role role = new Role();
//        role.setName("USER");
//        role.setDescription("一般用户");
//
//        roleMapper.save(role);


//        Permission permission = new Permission();
//        permission.setName("删除角色信息");
////        permission.setPid("5928f6ce-2feb-4334-974f-131c0ce8319a");
//        permission.setValue("DELETE_ROLE");
//        permission.setType("D");
//        permission.setStatus(0);
//
//        permission = permissionMapper.save(permission);
//
//        System.out.println(permission.toString());

//        RolePermission rolePermission = new RolePermission();
//        rolePermission.setRoleId("7975020a-03f4-4c7d-9c5d-26861febcae2");
//        rolePermission.setPermissionId("12e7e874-b041-400c-be11-25b08b308ad6");
//        rolePermissionMapper.save(rolePermission);

//        UserRole userRole = new UserRole();
//        userRole.setUserId("ad1e969f-7df4-4239-85ea-252ac891e8dc");
//        userRole.setRoleId("7975020a-03f4-4c7d-9c5d-26861febcae2");
//        userRoleMapper.save(userRole);

//        Optional<User> user = userMapper.findByUsername("jiuha");
//        Set<Permission> permissionList = userDetailService.getPermissionsOfUser(user.get());
//        permissionList.stream().forEach(System.out::println);

//        UserPermission userPermission = new UserPermission();
//        userPermission.setPermissionId("9c935d47-df24-4e65-88fd-3e55399b0f69");
//        userPermission.setUserId("ad1e969f-7df4-4239-85ea-252ac891e8dc");
//        userPermission.setType(-1);
//        userPermissionMapper.save(userPermission);

    }

}
