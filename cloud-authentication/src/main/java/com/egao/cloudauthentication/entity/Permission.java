package com.egao.cloudauthentication.entity;

import com.egao.cloudcommon.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * 权限实体类
 *
 * @author Jiuha
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_permission")
public class Permission extends BaseEntity {

    /**
     * 父权限ID
     */
    private String pid;

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限值（SpringSecurity getAuthority值）
     */
    private String value;

    /**
     * 权限类型
     */
    private String type;

    /**
     * 权限状态
     */
    private Integer status;
}
