package com.example.oauth2_1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login() // 인증 메서드(필터 체인에 oath2 관련 새 인증 필터 추가)
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
