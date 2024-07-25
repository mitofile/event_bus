package com.eventbus.sqrs.example.service;

import com.eventbus.sqrs.example.dto.OrderResponse;
import com.eventbus.sqrs.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {
    private final OrderRepository orderRepository;

    public OrderQueryServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> {
                    OrderResponse response = new OrderResponse();
                    response.setId(order.getId());
                    response.setProduct(order.getProduct());
                    response.setQuantity(order.getQuantity());
                    return response;
                }).collect(Collectors.toList());
    }
}
