package hello.order;

import java.util.concurrent.atomic.AtomicInteger;

public interface OrderService {
    void order();
    void cancel();
    //멀티 스레드 상황에서 안전하게 값들을 증가 감소 시킬 수 있다.
    AtomicInteger getStock();
}
