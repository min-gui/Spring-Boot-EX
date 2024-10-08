package hello.aop.sample.order.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* hello.aop.order..*(..))")
    public void allOrder(){} //pointcut signature

    //클래스 이름 패턴이 *Service.
    @Pointcut("execution(* *..*Service.*(..))")
    public void allService() {}

    @Around("allOrder()")
    @Pointcut("allOrder() && allService()")
    public void orderAndService() {}
}
