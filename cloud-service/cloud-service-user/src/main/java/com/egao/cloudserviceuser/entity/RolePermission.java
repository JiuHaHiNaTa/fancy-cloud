package com.egao.cloudserviceuser.entity;

import com.egao.cloudcommon.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色权限关联表
 *
 * @author Jiuha
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_role_permission")
public class RolePermission extends BaseEntity {

    /**
     * 角色主键ID
     */
    private String roleId;

    /**
     * 权限主键ID
     */
    private String permissionId;
}
