package com.sv.autokart.mapper;

import com.sv.autokart.dtos.OrderDetailsResponse;
import com.sv.autokart.dtos.OrderResponse;
import com.sv.autokart.models.Order;
import com.sv.autokart.models.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {
    @Mapping(target = "orderId", source = "orderId")
    @Mapping(target = "totalPrice", source = "totalPrice")
    @Mapping(target = "totalQuantity", source = "totalQuantity")
    @Mapping(target = "totalItems", source = "totalItems")
    @Mapping(target = "orderedDate", source = "orderedDate")
    @Mapping(target = "orderedItemImageUrl", source = "orderedItemImageUrl")
    public abstract OrderResponse mapToDto(Order order);

    @Mapping(target = "orderId", source = "order.orderId")
    @Mapping(target = "totalPrice", source = "order.totalPrice")
    @Mapping(target = "totalQuantity", source = "order.totalQuantity")
    @Mapping(target = "totalItems", source = "order.totalItems")
    @Mapping(target = "orderedDate", source = "order.orderedDate")
    @Mapping(target = "orderedItemImageUrl", source = "order.orderedItemImageUrl")
    @Mapping(target = "orderPaymentMode", source = "order.orderPaymentMode")
    @Mapping(target = "delieveryAddress", source = "order.delieveryAddress")
    @Mapping(target = "orderItems", source = "orderItems")
    public abstract OrderDetailsResponse mapToDtoDetails(Order order, List<OrderItem> orderItems);
}
