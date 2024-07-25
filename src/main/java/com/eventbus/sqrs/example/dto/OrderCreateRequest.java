package com.eventbus.sqrs.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateRequest {
    private String product;
    private int quantity;
}
