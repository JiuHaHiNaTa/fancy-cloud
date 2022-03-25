package com.egao.cloudserviceuser.entity;

import com.egao.cloudcommon.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户角色关联表
 *
 * @author Jiuha
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_user_role")
public class UserRole extends BaseEntity {

    private String userId;

    private String roleId;

}
