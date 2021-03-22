package com.sv.autokart.services;

import com.sv.autokart.dtos.OrderDetailsResponse;
import com.sv.autokart.dtos.OrderRequest;
import com.sv.autokart.dtos.OrderResponse;
import com.sv.autokart.exceptions.SpringAutoKartException;
import com.sv.autokart.mapper.OrderMapper;
import com.sv.autokart.models.Order;
import com.sv.autokart.models.OrderItem;
import com.sv.autokart.repositories.OrderItemRepository;
import com.sv.autokart.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderMapper orderMapper;
    private final AuthService authService;

    @Transactional(readOnly = true)
    public List<OrderResponse> getOrdersForUser(Long userId){
        return orderRepository.findAllByUserId(userId).stream().map(orderMapper::mapToDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDetailsResponse getOrderDetails(Long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(()->new SpringAutoKartException("Order not found"));
        List<OrderItem> orderItems = orderItemRepository.findAllByOrder(order);
        return orderMapper.mapToDtoDetails(order, orderItems);
    }

    @Transactional
    public void saveNewOrder(OrderRequest orderRequest){
        Order order = new Order();

        order.setUserId(authService.getCurrentUser().getUserId());
        order.setOrderPaymentMode(orderRequest.getOrderPaymentMode());
        order.setDelieveryAddress(orderRequest.getDelieveryAddress());
        order.setTotalItems(orderRequest.getTotalItems());
        order.setTotalPrice(orderRequest.getTotalPrice());
        order.setTotalQuantity(orderRequest.getTotalQuantity());
        order.setOrderedItemImageUrl(orderRequest.getOrderItemRequests().get(0).getAccessoryImageUrl());
        order.setOrderedDate(Instant.now());
        orderRepository.save(order);

        OrderItem orderItem = new OrderItem();
        orderRequest.getOrderItemRequests().forEach(orderItemRequest -> {
            orderItem.setOrder(order);
            orderItem.setAccessoryId(orderItemRequest.getAccessoryId());
            orderItem.setAccessoryImageUrl(orderItemRequest.getAccessoryImageUrl());
            orderItem.setAccessoryTitle(orderItemRequest.getAccessoryTitle());
            orderItem.setPrice(orderItemRequest.getPrice());
            orderItem.setQuantity(orderItemRequest.getQuantity());
            orderItem.setOrderedDate(Instant.now());
            orderItemRepository.save(orderItem);
        });
    }



}
