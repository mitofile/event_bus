package com.eventbus.sqrs.example.service;

import com.eventbus.sqrs.example.domain.Order;
import com.eventbus.sqrs.example.dto.OrderCreateRequest;

public interface OrderCommandService {
    Order createOrder(OrderCreateRequest request);
}
