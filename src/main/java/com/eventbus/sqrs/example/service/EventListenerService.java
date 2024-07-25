package com.eventbus.sqrs.example.service;

import com.eventbus.sqrs.example.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;

public class EventListenerService {
    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event){
        System.out.println("Order created: " + event.getOrder().getProduct());
    }
}
