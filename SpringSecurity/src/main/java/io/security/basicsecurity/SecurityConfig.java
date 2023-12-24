package io.security.basicsecurity;

import io.security.basicsecurity.config.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity 스프링 시큐리티 필터가 스프링 필터 체인에 등록됩니다.
@RequiredArgsConstructor
public class SecurityConfig {

    private final PrincipalOauth2UserService principalOauth2UserService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.
                authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests.anyRequest()
                            .permitAll();
                })
                .oauth2Login(oauth -> oauth
                        .loginPage("/test/loginPage")
                        .userInfoEndpoint(userInfo ->
                                userInfo
                                        //구글 로그인이 완료된 뒤 후처리가 필요함. Tip. 코드X, (엑세스토큰+사용자프로필정보O)
                                        .userService(principalOauth2UserService)
                        )
                )


//                                auth2.loginPage("/test/loginPage")

                /*.formLogin(formLogin -> {
                    formLogin
                            //.loginPage("/loginPage")
                            .defaultSuccessUrl("/")
                            .failureUrl("/login")
                            .usernameParameter("userId")
                            .passwordParameter("passwd")
                            .loginProcessingUrl("/login_proc")
                            //로그인 성공 했을때
//                            .successHandler((request, response, authentication) -> {
//                                System.out.println("authentication" + authentication.getName());
//                                response.sendRedirect("/");
//                            })
//                            .failureHandler(((request, response, exception) -> {
//                                System.out.println("exception" + exception.getMessage());
//                                response.sendRedirect("/login");
//                            }))
                            .permitAll();
                })*/
                .build();

    }
}
