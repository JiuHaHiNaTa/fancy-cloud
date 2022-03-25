package com.egao.cloudserviceuser.mapper;

import com.egao.cloudserviceuser.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * 角色权限关系表
 *
 * @author Jiuha
 */
public interface RolePermissionMapper extends JpaRepository<RolePermission, String> {

    /**
     * 根据角色查询角色拥有的权限
     * @param roleId 权限主键ID
     * @return 角色权限关联关系集合
     */
    Set<RolePermission> findByRoleId(String roleId);
}
