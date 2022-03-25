package com.egao.cloudserviceuser.vo;

import lombok.Data;

/**
 * 用户注册VO类
 *
 * @author Jiuha
 */
@Data
public class RegisterVO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;
}
