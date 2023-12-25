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
        //어떤 OAuth로 로그인 했는지 확인 가능
        log.info("getClientRegistration : {}", userRequest.getClientRegistration());
        log.info("getAccessToken : {}", userRequest.getAccessToken().getTokenValue());
        // 구글로그인 버튼 클릭 -> 구글 로그인창 -> 로그인을 완료 -> code를 리턴(OAuth-Client라이브러리) -> AccessToken요청

        log.info("getAttributes : {}", super.loadUser(userRequest).getAttributes());
        return super.loadUser(userRequest);
    }
}
