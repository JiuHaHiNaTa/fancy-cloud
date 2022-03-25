package com.egao.cloudauthentication.config.security;

import com.egao.cloudauthentication.config.jwt.JwtTokenEnhancer;
import com.egao.cloudauthentication.service.AuthenticationUserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 认证服务配置类
 *
 * @author Jiuha
 */
@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Resource
    CustomAuthenticationExceptionTranslator exceptionTranslator;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private AuthenticationUserDetailServiceImpl userDetailsService;

    @Resource
    private JwtAccessTokenConverter accessTokenConverter;

    @Resource
    private JwtTokenEnhancer jwtTokenEnhancer;

    @Resource
    private TokenStore tokenStore;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置服务认证
        clients.inMemory()
                .withClient("fancycloud")
                .secret(passwordEncoder().encode("123456"))
                .accessTokenValiditySeconds(7200)
                .refreshTokenValiditySeconds(864000)
                //TODO URL配置化，放入配置文件中，可以根据文件动态修改，添加新的callback节点进行授权
                .redirectUris("http://localhost:8090/login", "http://localhost:8090/oauth/callback")
                //自动授权配置
                .autoApprove(true)
                //TODO 魔法值修改枚举变量
                .authorizedGrantTypes(
                        "authorization_code",
                        "refresh_token",
                        "password"
                )
                //TODO 魔法值修改枚举变量
                .scopes("all", "resource:read", "resource:write");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        //配置JWT的内容增强器
        delegates.add(jwtTokenEnhancer);
        delegates.add(accessTokenConverter);
        enhancerChain.setTokenEnhancers(delegates);
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                //指定token存放位置
                .tokenStore(tokenStore)
                //配置JWT转换器
                .accessTokenConverter(accessTokenConverter)
                //配置JWT增强器
                .tokenEnhancer(enhancerChain)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);

        //配置日志信息控制台打印ERROR
        endpoints
                // Your usual config here .....
                .exceptionTranslator(exceptionTranslator);
    }

    /**
     * 加密实现，替换加密方法
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}
