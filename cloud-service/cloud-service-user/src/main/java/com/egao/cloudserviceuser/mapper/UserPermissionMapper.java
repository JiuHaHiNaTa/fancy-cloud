package com.egao.cloudserviceuser.mapper;

import com.egao.cloudserviceuser.entity.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * 用户权限关系补充表 关联表
 *
 * @author Jiuha
 */
public interface UserPermissionMapper extends JpaRepository<UserPermission, String> {

    /**
     * 根据用户主键ID查询用户补充权限关系
     *
     * @param userId 用户主键ID
     * @return 用户权限 关联关系集合
     */
    Set<UserPermission> findByUserId(String userId);

    /**
     * 根据用户主键ID和补充类型（type）查询用户补充权限关系
     *
     * @param userId 用户主键ID
     * @param type 补充类型
     * @return 用户权限 关联关系集合
     */
    Set<UserPermission> findByUserIdAndAndType(String userId, Integer type);
}
