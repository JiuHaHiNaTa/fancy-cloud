package com.egao.cloudserviceapiauth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 登录验证调用认证中心服务
 *
 * @author Jiuha
 */
@Component
@FeignClient(value = "cloud-authentication")
public interface AuthFeignClient {

    /**
     * 调用认证中心服务获取信息
     *
     * @param parameters 请求参数
     * @return OAuth2AccessToken
     */
    @RequestMapping(value = "/oauth/token")
    ResponseEntity<OAuth2AccessToken> findTokenInfo(@RequestParam Map<String, String> parameters);
}
