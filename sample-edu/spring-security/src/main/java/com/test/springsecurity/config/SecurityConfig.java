package com.test.springsecurity.config;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorization -> authorization.anyRequest().authenticated())
                .formLogin(formLoginCustomizer -> {
                    formLoginCustomizer.loginPage("/loginPage")
                            .defaultSuccessUrl("/")
                            .failureUrl("/login")
                            .usernameParameter("userId")
                            .passwordParameter("passwd")
                            .loginProcessingUrl("/login_proc")
                            .successHandler(new AuthenticationSuccessHandler() {

                                @Override
                                public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
                                        throws IOException, ServletException {
                                    log.info("authentication" + authentication.getName());
                                    response.sendRedirect("/");

                                }
                            })
                            .failureHandler(new AuthenticationFailureHandler() {
                                @Override
                                public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
                                        throws IOException, ServletException {
                                    log.info("exception" + exception.getMessage());
                                    response.sendRedirect("/login");
                                }
                            })
                    ;
                })

        ;


        return http.build();
    }
}
