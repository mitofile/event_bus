package com.eventbus.sqrs.example.repository;

import com.eventbus.sqrs.example.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
