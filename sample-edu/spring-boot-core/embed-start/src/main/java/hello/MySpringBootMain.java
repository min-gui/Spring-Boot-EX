package hello;
//여기 패키지 부터 하위에 모든것들으 컴포넌트 스캔의 대상으로 생각한다.
import hello.boot.MySpringApplication;
import hello.boot.MySpringBootApplication;
import org.apache.catalina.LifecycleException;

@MySpringBootApplication
public class MySpringBootMain  {
    public static void main(String[] args) {
        MySpringApplication.run(MySpringBootMain.class, args);
    }
}
