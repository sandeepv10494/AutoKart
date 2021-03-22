package com.sv.autokart.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {
    private Double price;
    private Long quantity;
    private Long accessoryId;
    private String accessoryTitle;
    private String accessoryImageUrl;
}
