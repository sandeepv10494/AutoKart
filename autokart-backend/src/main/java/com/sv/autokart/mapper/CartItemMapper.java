package com.sv.autokart.mapper;

import com.sv.autokart.dtos.CartItemListResponse;
import com.sv.autokart.models.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CartItemMapper {
    @Mapping(target = "cartItemId", source = "cartItemId")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "accessoryId", source = "accessory.accesoryId")
    @Mapping(target = "accessoryTitle", source = "accessory.title")
    @Mapping(target = "accessoryImageURL", source = "accessory.imageUrl")
    public abstract CartItemListResponse mapToDto(CartItem cartItem);
}
