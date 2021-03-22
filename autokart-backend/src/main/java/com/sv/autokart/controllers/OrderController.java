package com.sv.autokart.controllers;

import com.sv.autokart.dtos.OrderDetailsResponse;
import com.sv.autokart.dtos.OrderRequest;
import com.sv.autokart.dtos.OrderResponse;
import com.sv.autokart.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/by-user/{userid}")
    public ResponseEntity<List<OrderResponse>> getlistOfOrdersForUser(@PathVariable Long userid){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrdersForUser(userid));
    }

    @GetMapping("/{orderid}")
    public ResponseEntity<OrderDetailsResponse> getOrderDetails(@PathVariable Long orderid){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderDetails(orderid));
    }

    @PostMapping
    public ResponseEntity<String> createNewOrder(@RequestBody OrderRequest orderRequest){
        orderService.saveNewOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order created successfully");
    }
}
