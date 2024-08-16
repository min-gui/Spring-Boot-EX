package hello.aop.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


public interface Shop {
    String getShopCd();
    String getShopNm();
    String getAddress();
    String getPhoneNumber();
    LocalDate getOpenDate();
    String getShopType();
    LocalDateTime getInsAt();
    LocalDateTime getUpdAt();
}
