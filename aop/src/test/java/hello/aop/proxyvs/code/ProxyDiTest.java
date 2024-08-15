package hello.aop.proxyvs.code;

import hello.aop.sample.member.MemberService;
import hello.aop.sample.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=false"}) //JDK 동적 프록시
@SpringBootTest(properties = {"spring.aop.proxy-target-class=true"}) //JDK 동적 프록시
@Import(ProxyDiAspect.class)
public class ProxyDiTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberServiceImpl memberServiceImpl;

    @Test
    public void go() {
        log.info("memberService class{} ",memberService.getClass());
        log.info("memberServiceImpl class{} ",memberServiceImpl.getClass());
        memberServiceImpl.hello("hello");
    }
}
