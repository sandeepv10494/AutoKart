package com.sv.autokart.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long userId;
    private OrderPaymentMode orderPaymentMode;
    private String delieveryAddress;
    private Long totalPrice;
    private Long totalQuantity;

   @OneToMany
    private List<OrderItem> orderItems;

    private Instant orderedDate;
}
