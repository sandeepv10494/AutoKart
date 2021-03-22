package com.sv.autokart.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRatingRequest {
    private Long accessoryId;
    private Double rating;
    private String commentDescription;
    private String commentTitle;
}
