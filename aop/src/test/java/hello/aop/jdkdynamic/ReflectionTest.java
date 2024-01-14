package hello.aop.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();

        log.info("start a");
        String callA = target.callA();
        log.info("result a : {}", callA);

        log.info("start b");
        String callB = target.callB();
        log.info("result b : {}", callB);

    }

    @Test
    public void reflection1() throws Exception {
        //given
        Class classHello = Class.forName("hello.aop.jdkdynamic.ReflectionTest$Hello");

        //when
        Hello target = new Hello();

        //callA 메소드 정보.
        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);
        log.info("result1 : {}", result1);

        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result1 : {}", result2);

    }

    @Test
    public void reflection2() throws Exception {
        //given
        Class classHello = Class.forName("hello.aop.jdkdynamic.ReflectionTest$Hello");

        //when
        Hello target = new Hello();

        //callA 메소드 정보.
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);

        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);

    }

    public void dynamicCall(Method method, Object target) throws Exception {
        log.info("start");
        //이부분이 추상화 된거다.
        Object result1 = method.invoke(target);
        log.info("result1 : {}", result1);
    }


    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }

    }
}
