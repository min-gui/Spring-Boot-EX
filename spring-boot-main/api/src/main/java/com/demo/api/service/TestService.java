package com.demo.api.service;

import com.demo.domain.dao.Order;
import com.demo.domain.entity.OrderEntity;
import com.demo.domain.repository.primary.OrderRepositoryPrimary;
import com.demo.domain.repository.primary.mapper.OrderMapper;
import com.demo.domain.repository.secondary.OrderRepositorySecondary;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    private final OrderRepositoryPrimary orderRepositoryPrimary;

    private final OrderRepositorySecondary orderRepositorySecondary;

    private final OrderMapper orderMapper;

    public void testVoid() throws RuntimeException {
        OrderEntity orderEntity = orderRepositoryPrimary.findById(2L).orElseThrow();
        log.info("orderEntity : {}", orderEntity.getShopCd());
        OrderEntity orderEntity2 = orderRepositorySecondary.findById(4L).orElseThrow();
        log.info("orderEntity2 : {}", orderEntity2.getShopCd());

        Order order = orderMapper.findById(2L);
        log.info("order : {}", order.getShopCd());
    }


}
