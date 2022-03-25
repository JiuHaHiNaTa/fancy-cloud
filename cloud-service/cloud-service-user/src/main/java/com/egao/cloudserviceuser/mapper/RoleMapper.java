package com.egao.cloudserviceuser.mapper;

import com.egao.cloudserviceuser.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色DAO
 *
 * @author Jiuha
 */
@Repository
public interface RoleMapper extends JpaRepository<Role, String> {
}
