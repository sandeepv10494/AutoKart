package com.sv.autokart.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessoryListResponse {
    private Long accesoryId;
    private String title;
    private String imageUrl;
    private Long price;
}
