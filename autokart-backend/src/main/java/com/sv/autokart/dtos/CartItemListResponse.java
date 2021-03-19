package com.sv.autokart.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItemListResponse {
    private Long cartItemId;
    private Long userId;
    private Long quantity;
    private Long price;
    private Long accessoryId;
    private String accessoryTitle;
    private String accessoryImageURL;
}
