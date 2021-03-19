package com.sv.autokart.mapper;

import com.sv.autokart.dtos.WishlistResponse;
import com.sv.autokart.models.Wishlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class WishlistMapper {

    @Mapping(target = "wishlistItemId", source = "id")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "accessoryId", source = "accessory.accesoryId")
    @Mapping(target = "accessoryTitle", source = "accessory.title")
    @Mapping(target = "accessoryImageURL", source = "accessory.imageUrl")
    public abstract WishlistResponse mapToDto(Wishlist wishlist);
}
