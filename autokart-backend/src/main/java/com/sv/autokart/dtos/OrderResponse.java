package com.sv.autokart.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long orderId;
    private Long totalPrice;
    private Long totalQuantity;
    private Long totalItems;
    private Instant orderedDate;
    private String orderedItemImageUrl;
}
