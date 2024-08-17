package hello.aop.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShopVO {
    private String shopCd;
    private String shopNm;
    private String address;
    private String phoneNumber;
    private LocalDate openDate;
    private String shopType;
    private LocalDateTime insAt;
    private LocalDateTime updAt;
}
