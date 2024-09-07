package com.demo.domain.repository;

import com.demo.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
