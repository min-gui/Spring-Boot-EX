package hello.aop.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_shop")
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10)
    private String shopCd;

    @Column(length = 10)
    private String shopNm;

    @Column(length = 255)
    private String address;

    @Column(length = 20)
    private String phoneNumber;

    private LocalDate openDate;

    @Column(length = 50)
    private String shopType;

    @Column(nullable = false)
    private LocalDateTime insAt;

    @Column(nullable = false)
    private LocalDateTime updAt;
}
