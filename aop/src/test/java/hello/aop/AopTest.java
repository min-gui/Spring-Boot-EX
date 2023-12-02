package hello.aop;

import hello.aop.order.OrderRepository;
import hello.aop.order.OrderService;
import hello.aop.order.aop.AspectV3;
import hello.aop.order.aop.AspectV4Pointcut;
import hello.aop.order.aop.AspectV5Order;
import hello.aop.order.aop.AspectV6Advice;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootTest
//@Import(AspectV1.class)
//@Import(AspectV2.class)
//@Import(AspectV3.class) //스프링 빈으로 등록
//@Import(AspectV4Pointcut.class)
//@Import({AspectV5Order.LogAspect.class, AspectV5Order.TransactionAspect.class})
@Import(AspectV6Advice.class)
public class AopTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void appInfo() throws Exception {
        log.info("isAopProxy, orderService={}", AopUtils.isAopProxy(orderService));
        log.info("isAopProxy, orderRepository={}", AopUtils.isAopProxy(orderRepository));

    }
        
    @Test
    public void success() throws Exception {
        //given
        orderService.orderItem("itemA");
        //when
        orderService.test();

        //then

     }

     @Test
     public void exception() throws Exception {
         //given
         //when
         Assertions.assertThatThrownBy(() -> orderService.orderItem("ex"))
                 .isInstanceOf(IllegalStateException.class);
//                 .hasMessageContaining("예외 발생");
         //then

      }





    
}
