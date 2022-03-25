package com.egao.cloudauthentication.entity;

import com.egao.cloudcommon.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户权限关联表
 *
 * @author Jiuha
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_user_permission")
public class UserPermission extends BaseEntity {

    /**
     * 用户主键ID
     */
    private String userId;

    /**
     * 权限主键ID
     */
    private String permissionId;

    /**
     * 权限类型
     * 1 - 增加权限 | -1 - 减少权限
     */
    private Integer type;

}
