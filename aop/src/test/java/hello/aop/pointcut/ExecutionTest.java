package hello.aop.pointcut;

import hello.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ExecutionTest {

    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    @Test
    public void printMethod() throws Exception {
        //execution( * ..package..Class)
        //given
        log.info("helloMethod={}", helloMethod);

        //when

        //then

    }

    @Test
    public void exactMatch() throws Exception {
        //given
        pointcut.setExpression("execution(public String hello.aop.member.MemberServiceImpl.hello(String))");
        //when

        //then
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    public void allMatch() throws Exception {
        //가장 많이 생략한 포인트 컷
        //given
        pointcut.setExpression("execution(* *(..))");
        //when
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();

        //then

    }

    @Test
    public void nameMatch() throws Exception {
        pointcut.setExpression("execution(* hello(..))");
        //when
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();

    }

    @Test
    public void nameMatchStar1() throws Exception {
        pointcut.setExpression("execution(* hel*(..))");
        //when
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();

    }

    @Test
    public void nameMatchStar2() throws Exception {
        pointcut.setExpression("execution(* *hel*(..))");
        //when
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();

    }

    @Test
    public void nameMatchFalse() throws Exception {
        pointcut.setExpression("execution(* *non(..))");
        //when
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isFalse();

    }

    @Test
    public void packageExactMatch1() throws Exception {
        pointcut.setExpression("execution(* hello.aop.member.MemberServiceImpl.hello(..))");
        //when
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();

    }

    @Test
    public void packageExactMatch2() throws Exception {
        pointcut.setExpression("execution(* hello.aop.member.*.*(..))");
        //when
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();

    }

    @Test
    public void packageExactFalse() throws Exception {
        pointcut.setExpression("execution(* hello.aop.*.*(..))");
        //when
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isFalse();

    }

    @Test
    public void packageMatchSubPackage1() throws Exception {
        pointcut.setExpression("execution(* hello.aop.member..*.*(..))");
        //when
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();

    }

    @Test
    public void packageMatchSubPackage2() throws Exception {
        pointcut.setExpression("execution(* hello.aop..*.*(..))");
        //when
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();

    }

}
