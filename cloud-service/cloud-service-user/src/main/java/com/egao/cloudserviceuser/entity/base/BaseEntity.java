package com.egao.cloudserviceuser.entity.base;

import lombok.Data;
import org.hibernate.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 提取公共属性抽象实体类
 *
 * @author Jiuha
 */
@Data
@MappedSuperclass
public abstract class BaseEntity {

    @GenericGenerator(name = "jpa-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "jpa-uuid")
    @Id
    @Column(length = 100)
    private String id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    private LocalDateTime createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    private LocalDateTime updateTime;


    @Column(insertable = false, columnDefinition = "int default 0")
    private Integer deleteFlag;
}
