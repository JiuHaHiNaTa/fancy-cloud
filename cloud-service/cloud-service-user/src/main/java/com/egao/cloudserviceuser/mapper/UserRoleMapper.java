package com.egao.cloudserviceuser.mapper;


import com.egao.cloudserviceuser.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 用户角色关联表DAO
 *
 * @author Jiuha
 */
public interface UserRoleMapper extends JpaRepository<UserRole, String> {

    /**
     * 根据用户ID查询角色关联关系
     * @param userId 用户主键ID
     * @return 用户角色关联关系
     */
    UserRole findByUserId(String userId);
}
