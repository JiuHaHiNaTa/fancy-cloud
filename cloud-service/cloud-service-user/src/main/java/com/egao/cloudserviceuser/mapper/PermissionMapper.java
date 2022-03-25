package com.egao.cloudserviceuser.mapper;

import com.egao.cloudserviceuser.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


/**
 * 权限DAO
 *
 * @author Jiuha
 */
public interface PermissionMapper extends JpaRepository<Permission, String> {

    /**
     * 根据主键ID集合查询权限集合
     * @param ids 主键ID集合
     * @return 权限集合
     */
    Set<Permission> findByIdIn(Set<String> ids);
}
