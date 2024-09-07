package com.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    /**
     * 매장코드||
     */
//    @Column(name = "shop_cd")
    private String shopCd;

    private LocalDate saleDate;
    private String orderNo;
    private String billNo;
    private String prodInfo;
    private String orderReqDesc;
    private LocalDateTime insAt;
    private String insId;
    private LocalDateTime updAt;
    private String updId;
}
