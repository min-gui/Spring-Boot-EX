package hello.aop.internalcall;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV2 {

    //이방법도 약간 억지로 맞추는 방법이다.

    //스프링이 주입 받을 수 있도록 해준다.
    //private final ApplicationContext applicationContext;
    private final ObjectProvider<CallServiceV2> callserviceProvider;

    public CallServiceV2(ObjectProvider<CallServiceV2> callserviceProvider) {
        this.callserviceProvider = callserviceProvider;
    }

//    public CallServiceV2(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }

    public void external() {
        log.info("call external");
//        CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);//외부 메서드 호출
        CallServiceV2 callServiceV2 = callserviceProvider.getObject();//외부 메서드 호출
        callServiceV2.internal(); //외부 메서드 호출
    }
    public void internal() {
        log.info("call internal");
    }

}
