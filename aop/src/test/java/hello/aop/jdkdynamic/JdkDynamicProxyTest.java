package hello.aop.jdkdynamic;

import hello.aop.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    public void dynamicA() throws Exception {
        //given
        AInterface target = new AImpl();

        //when
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        AInterface proxy = (AInterface) Proxy.newProxyInstance(
                AInterface.class.getClassLoader(),
                new Class[]{AInterface.class},
                handler
        );

        proxy.call();
        log.info("target {}", target.getClass());
        log.info("proxy {}", proxy.getClass());
        //then

    }
    @Test
    public void dynamicB() throws Exception {
        //given
        BInterface target = new BImpl();

        //when
        //이거 하나만 만들어 놓고 하위 부터 변경
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        BInterface proxy = (BInterface) Proxy.newProxyInstance(
                BInterface.class.getClassLoader(),
                new Class[]{BInterface.class},
                handler
        );

        proxy.call();
        log.info("target {}", target.getClass());
        log.info("proxy {}", proxy.getClass());
        //then

    }


}
