package com.sv.autokart.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    private Double price;
    private Long quantity;
    private Long accessoryId;
    private String accessoryTitle;
    private String accessoryImageUrl;
    private Instant orderedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderId", referencedColumnName = "orderId")
    private Order order;
}
