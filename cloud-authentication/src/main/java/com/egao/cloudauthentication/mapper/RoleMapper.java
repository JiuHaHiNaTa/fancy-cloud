package com.egao.cloudauthentication.mapper;

import com.egao.cloudauthentication.entity.Role;
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
