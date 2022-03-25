package com.egao.cloudcommon.entity;

import lombok.Data;

/**
 * 封装Token信息
 *
 * @author Jiuha
 */
@Data
public class TokenInfo {

    private String accessToken;

    private String tokenType;

    private String refreshToken;

    private String expiresIn;

    private String scope;

    private String enhance;

    private String jti;
}
