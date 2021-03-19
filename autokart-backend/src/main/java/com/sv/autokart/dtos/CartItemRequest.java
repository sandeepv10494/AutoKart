package com.sv.autokart.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemRequest {
    private Long quantity;
    private Long userId;
    private Long accessoryId;
}
