package com.sv.autokart.controllers;

import com.sv.autokart.dtos.UserRatingRequest;
import com.sv.autokart.models.UserRating;
import com.sv.autokart.services.UserRatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userratings")
@AllArgsConstructor
public class UserRatingController {
    private final UserRatingService userRatingService;

    @PostMapping
    public ResponseEntity<String> createNewRating(@RequestBody UserRatingRequest userRatingRequest){
        userRatingService.saveRating(userRatingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rating created successfully");
    }

    @GetMapping("/by-user/{userid}")
    public ResponseEntity<List<UserRating>> getRatingsForUser(@PathVariable Long userid){
        return ResponseEntity.status(HttpStatus.OK).body(userRatingService.getRatingsByUser(userid));
    }

    @GetMapping("/by-accessory/{accessoryid}")
    public ResponseEntity<List<UserRating>> getRatingsForAccessory(@PathVariable Long accessoryid){
        return ResponseEntity.status(HttpStatus.OK).body(userRatingService.getRatingsForAccessory(accessoryid));
    }
}
