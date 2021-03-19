package com.sv.autokart.controllers;

import com.sv.autokart.dtos.CartItemListResponse;
import com.sv.autokart.dtos.CartItemRequest;
import com.sv.autokart.services.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @GetMapping("/{userid}")
    public ResponseEntity<List<CartItemListResponse>> getCartItemsForUser(@PathVariable Long userid){
        return ResponseEntity.status(HttpStatus.OK).body(cartItemService.getAllCartItemForUser(userid));
    }

    @PostMapping
    public ResponseEntity<String> createNewCartItem(@RequestBody CartItemRequest cartItemRequest){
        cartItemService.saveCartItem(cartItemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Accessory added to cart successfully");
    }

    @PutMapping("/{cartitemid}")
    public ResponseEntity<String> updateCartItems(@PathVariable Long cartitemid, @RequestParam(name = "quantity") Long quantity){
        cartItemService.updateCartItem(cartitemid,quantity);
        return ResponseEntity.status(HttpStatus.OK).body("Cartitem updated successfully");
    }

    @DeleteMapping("/{cartitemid}")
    public ResponseEntity<String> deleteCartItems(@PathVariable Long cartitemid){
        cartItemService.deleteCartItem(cartitemid);
        return ResponseEntity.status(HttpStatus.OK).body("Cartitem deleted successfully");
    }
}
