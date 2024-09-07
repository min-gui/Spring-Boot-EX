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
    @Column(name = "shop_cd")
    private String shopCd;
    @Column(name = "sale_date")
    private LocalDate saleDate;
    @Column(name = "order_no")
    private String orderNo;
    @Column(name = "bill_no")
    private String billNo;
    @Column(name = "prod_info")
    private String prodInfo;
    @Column(name = "order_req_desc")
    private String orderReqDesc;
    @Column(name = "ins_at")
    private LocalDateTime insAt;
    @Column(name = "ins_id")
    private String insId;
    @Column(name = "upd_at")
    private LocalDateTime updAt;
    @Column(name = "upd_id")
    private String updId;
}
