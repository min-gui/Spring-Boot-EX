package hello.aop.sample.member;

import hello.aop.sample.member.annotation.ClassAop;
import hello.aop.sample.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@ClassAop
@Component
public class MemberServiceImpl implements MemberService {
    @Override
    @MethodAop("test Value")
    public String hello(String param) {
        return "ok" ;
    }

    public String internal(String param) {
        return "ok"  ;
    }
}
