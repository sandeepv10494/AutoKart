package com.sv.autokart.dtos;

import com.sv.autokart.models.OrderPaymentMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private OrderPaymentMode orderPaymentMode;
    private String delieveryAddress;
    private Long totalPrice;
    private Long totalQuantity;
    private Long totalItems;
    private List<OrderItemRequest> orderItemRequests;
}
