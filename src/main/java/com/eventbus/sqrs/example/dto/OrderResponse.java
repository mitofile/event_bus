package com.eventbus.sqrs.example.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private String product;
    private int quantity;
}
