package io.security.basicsecurity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {


    //구글로 부터 받은 로그인 완료후 후처리 된다.
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("getClientRegistration : {}", userRequest.getClientRegistration());
        log.info("getAccessToken : {}", userRequest.getAccessToken());
        log.info("getAttributes : {}", super.loadUser(userRequest).getAttributes());
        return super.loadUser(userRequest);
    }
}
