package com.sv.autokart.controllers;

import com.sv.autokart.dtos.WishlistResponse;
import com.sv.autokart.services.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wishlist")
@AllArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;

    @GetMapping("/{userid}")
    public ResponseEntity<List<WishlistResponse>> getWishlistItems(@PathVariable Long userid){
        return ResponseEntity.status(HttpStatus.OK).body(wishlistService.getAllWishListItemsForUser(userid));
    }

    @PutMapping("/{userid}/{accessoryid}")
    public ResponseEntity<String> updateWishlistItems(@PathVariable Long userid, @PathVariable Long accessoryid){
        wishlistService.toggleWishList(accessoryid, userid);
        return ResponseEntity.status(HttpStatus.OK).body("Wishlist updated successfully");
    }
}
