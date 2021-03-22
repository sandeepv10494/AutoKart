package com.sv.autokart.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRatingId;

    private Long accessoryId;
    private Long userId;
    private String commentedBy;
    private Double rating;
    private String commentDescription;
    private String commentTitle;
    private Instant createdDate;
}
