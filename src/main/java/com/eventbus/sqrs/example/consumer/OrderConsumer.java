package com.eventbus.sqrs.example.consumer;

import com.eventbus.sqrs.example.domain.Order;
import com.eventbus.sqrs.example.repository.OrderRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private OrderRepository orderRepository;

    public OrderConsumer(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "order-events", groupId = "order-service-group")
    public void consume(Order order){
        System.out.println("Consumed order: " + order.toString());
    }
}
