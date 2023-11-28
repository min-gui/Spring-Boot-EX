package hello.aop;

import hello.aop.order.OrderRepository;
import hello.aop.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@Slf4j
@SpringBootTest
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
