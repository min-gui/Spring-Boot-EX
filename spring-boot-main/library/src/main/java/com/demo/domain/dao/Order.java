package com.demo.domain.dao;

import lombok.*;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Mapper
@AllArgsConstructor
@RequiredArgsConstructor
public class Order {

    private long id;
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
