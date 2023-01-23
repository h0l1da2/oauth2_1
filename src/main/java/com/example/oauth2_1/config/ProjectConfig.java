package com.example.oauth2_1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    /**
     * 깃허브를 클라이언트로 등록
     * 일반적인 공급자로 지정되어 있어서
     * CommonOAuth2Provider 로 쉽게 이용 가능(부분 정의 되어 있음)
     * -클라이언트 아이디
     * -클라이언트 id, secret (자격 증명)
     * 두 개만 필요(일반 공급자 한정)
     */
    private ClientRegistration clientRegistration() {
        return CommonOAuth2Provider.GITHUB
                .getBuilder("github")
                .clientId("1a58e6491976749ce819")
                .clientSecret("543bb69026e334d17320cf91085a9f498a837485")
                .build();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login() // 인증 메서드(필터 체인에 oath2 관련 새 인증 필터 추가)
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
