package hello.proxy.app.v2;

public class OrderRepositoryV2 {

    public void save(String itemId) {

        if (itemId.equals("ex")){
            throw new IllegalArgumentException("예외 발생");
        }
        sleep(1000);
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
