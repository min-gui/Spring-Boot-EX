package com.demo.domain.repository.primary;

import com.demo.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepositoryPrimary extends JpaRepository<OrderEntity, Long> {
}
