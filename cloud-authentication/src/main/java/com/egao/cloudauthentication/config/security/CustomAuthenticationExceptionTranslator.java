package com.egao.cloudauthentication.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * 自定义异常处理翻译
 * 配置WebResponseExceptionTranslator自定义异常，并重写translate方法返回自定义Oauth2认证异常信息
 *
 * @author Jiuha
 */
@Slf4j
@Component
public class CustomAuthenticationExceptionTranslator extends DefaultWebResponseExceptionTranslator {

    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
        // This is the line that prints the stack trace to the log. You can customise this to format the trace etc if you like
        e.printStackTrace();
        // Carry on handling the exception
        ResponseEntity<OAuth2Exception> responseEntity = super.translate(e);
        HttpHeaders headers = new HttpHeaders();
        headers.setAll(responseEntity.getHeaders().toSingleValueMap());
        OAuth2Exception excBody = responseEntity.getBody();
        return new ResponseEntity<>(excBody, headers, responseEntity.getStatusCode());
    }

}
