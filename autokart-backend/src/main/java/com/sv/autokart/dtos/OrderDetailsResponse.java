package com.sv.autokart.dtos;

import com.sv.autokart.models.OrderItem;
import com.sv.autokart.models.OrderPaymentMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsResponse {
    private Long orderId;
    private Long userId;
    private OrderPaymentMode orderPaymentMode;
    private String delieveryAddress;
    private Long totalPrice;
    private Long totalQuantity;
    private Long totalItems;
    private Instant orderedDate;
    private String orderedItemImageUrl;
    private List<OrderItem> orderItems;
}
