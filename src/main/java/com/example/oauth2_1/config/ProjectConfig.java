package com.example.oauth2_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    /**
     * UsersDetailsService 와 같은 역할을 한다
     * ClientRegistrationRepository 는 등록 ID로
     * ClientRegistration 를 찾는다
     */
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        ClientRegistration clientRegistration = clientRegistration();
//        return new InMemoryClientRegistrationRepository(clientRegistration);
//    }

    /**
     * 깃허브를 클라이언트로 등록
     * 일반적인 공급자로 지정되어 있어서
     * CommonOAuth2Provider 로 쉽게 이용 가능(부분 정의 되어 있음)
     * -클라이언트 아이디
     * -클라이언트 id, secret (자격 증명)
     * 두 개만 필요(일반 공급자 한정)
     * 얘는 라잌 UsersDetails
     */
//    private ClientRegistration clientRegistration() {
//        return CommonOAuth2Provider.GITHUB
//                .getBuilder("github")
//                .clientId("1a58e6491976749ce819")
//                .clientSecret("543bb69026e334d17320cf91085a9f498a837485")
//                .build();
//    }

    /**
     * application.properties 에 클라이언트 정보를 등록하면
     * 굳이 클래스에서 다른 설정 안 해도 됨
     * -
     * 다만, 등록 세부 정보를 저장하거나
     * 웹 서비스에서 얻거나 하는 다른 기능이 필요하면
     * ClientRegistrationRepository 를 커스텀 하는 것이 맞다
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login() // 인증 메서드(필터 체인에 oath2 관련 새 인증 필터 추가)
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    /**
     * 이렇게 Customizer 로도
     * clientRegistrationRepository 객체를 설정할 수 있다
     * 하지만 한 옵션을 선택하면 구성 방식을 혼용하진 말자
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.oauth2Login(c -> {
//            c.clientRegistrationRepository(clientRegistrationRepository())
//                }) // 인증 메서드(필터 체인에 oath2 관련 새 인증 필터 추가)
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated();
//    }
}
