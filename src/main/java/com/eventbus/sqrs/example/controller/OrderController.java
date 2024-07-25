package com.eventbus.sqrs.example.controller;

import com.eventbus.sqrs.example.dto.OrderCreateRequest;
import com.eventbus.sqrs.example.dto.OrderResponse;
import com.eventbus.sqrs.example.service.OrderCommandService;
import com.eventbus.sqrs.example.service.OrderQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderCommandService orderCommandService;
    private final OrderQueryService orderQueryService;

    public OrderController(OrderCommandService orderCommandService, OrderQueryService orderQueryService){
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
    }

    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderCreateRequest request){
        var order = orderCommandService.createOrder(request);
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setProduct(order.getProduct());
        response.setQuantity(order.getQuantity());
        return response;
    }

    @GetMapping
    public List<OrderResponse> getAllOrders(){
        return orderQueryService.getAllOrders();
    }
}
