package com.egao.cloudauthentication.entity;

import com.egao.cloudcommon.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色表
 *
 * @author Jiuha
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_role")
public class Role extends BaseEntity {

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

}
