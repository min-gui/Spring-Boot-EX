package hello.aop.sample.internalcall;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV0 {

    public void external() {
        log.info("call external");
        // 내부 메서드 호출
        internal();
    }

    public void internal() {
        log.info("call internal");
    }
}
