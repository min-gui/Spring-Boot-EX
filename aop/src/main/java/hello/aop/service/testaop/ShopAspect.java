package hello.aop.service.testaop;

import hello.aop.annotation.ShopValidation;
import hello.aop.model.ShopVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ShopAspect {
    @Around("@annotation(shopValidation)")
    public Object doShopValidation(ProceedingJoinPoint joinPoint, ShopValidation shopValidation) throws Throwable {
        log.info("[doShopValidation] {} args={}", joinPoint.getSignature());
        joinPoint.getArgs();

        // shopVO 넣는 테스트
        Object[] args = joinPoint.getArgs();
        ShopVO shopVO = ShopVO.builder().shopCd("aspect shop").shopNm("aspect NM").build();

        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ShopVO) {
                args[i] = shopVO; // 헤더 값을 해당 파라미터에 주입
            }
        }

        return joinPoint.proceed(joinPoint.getArgs());
    }

}
