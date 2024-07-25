package com.eventbus.sqrs.example.service;

import com.eventbus.sqrs.example.domain.Order;
import com.eventbus.sqrs.example.dto.OrderCreateRequest;
import com.eventbus.sqrs.example.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {
    private static final String TOPIC = "order-events";

    private final OrderRepository orderRepository;
    private KafkaTemplate<String, Order> kafkaTemplate;

    public OrderCommandServiceImpl(OrderRepository orderRepository, KafkaTemplate<String, Order> kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    @Transactional
    public Order createOrder(OrderCreateRequest request){
        Order order = new Order();
        order.setProduct(request.getProduct());
        order.setQuantity(request.getQuantity());
        order = orderRepository.save(order);
        kafkaTemplate.send(TOPIC, order);
        return order;
    }
}
