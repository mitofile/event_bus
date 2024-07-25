package com.eventbus.sqrs.example.service;

import com.eventbus.sqrs.example.dto.OrderResponse;

import java.util.List;

public interface OrderQueryService {
    List<OrderResponse> getAllOrders();
}
