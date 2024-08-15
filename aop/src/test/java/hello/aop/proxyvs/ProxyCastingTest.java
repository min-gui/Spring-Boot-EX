package hello.aop.proxyvs;

import hello.aop.sample.member.MemberService;
import hello.aop.sample.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

public class ProxyCastingTest {

    @Test
    public void jdkProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(false);

        //프록시를 인터페이스 캐스팅 성공
        //given
        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();

        //JDK 동적 프록시를 구현 클래스로 캐스팅 시도 실패
        //when
        Assertions.assertThrows(ClassCastException.class, () -> {
            MemberServiceImpl memberService = (MemberServiceImpl) memberServiceProxy;
        });
        //then
    }

    @Test
    public void cglibProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true);

        //프록시를 인터페이스 캐스팅 성공
        //given
        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();

        //CGLIB 동적 프록시를 구현 클래스로 캐스팅 시도 성공
        //when
        MemberServiceImpl memberService = (MemberServiceImpl) memberServiceProxy;

        //then
    }
}
