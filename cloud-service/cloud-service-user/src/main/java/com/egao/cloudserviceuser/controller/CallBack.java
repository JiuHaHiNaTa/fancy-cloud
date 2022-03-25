package com.egao.cloudserviceuser.controller;

import com.egao.cloudcommon.entity.TokenInfo;
import com.google.common.collect.Maps;
import org.checkerframework.checker.units.qual.C;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 授权码模式 认证中心回调接口
 *
 * @author Jiuha
 */
@RestController
public class CallBack {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 授权码回调接口
     *
     * @param code  授权码
     * @param state 其他附加信息（比如权限信息）
     * @return 返回ResponseEntity
     */
    @RequestMapping("/oauth/callback")
    public ResponseEntity<String> authorizationCallback(String code, String state) {
        return ResponseEntity.ok(code);
    }

}
