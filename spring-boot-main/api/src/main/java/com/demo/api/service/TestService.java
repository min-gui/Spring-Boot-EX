package com.demo.api.service;

import com.demo.domain.entity.OrderEntity;
import com.demo.domain.repository.primary.OrderRepositoryPrimary;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    private final OrderRepositoryPrimary orderRepositoryPrimary;

    public void testVoid() throws RuntimeException {
        OrderEntity orderEntity = orderRepositoryPrimary.findById(2L).orElseThrow();
        log.info("orderEntity : {}", orderEntity.getShopCd());

    }
}
