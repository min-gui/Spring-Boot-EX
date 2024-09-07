package com.demo.domain.repository.secandary;

import com.demo.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepositorySecondary extends JpaRepository<OrderEntity, Long> {
}
