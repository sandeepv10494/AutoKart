package com.sv.autokart.mapper;

import com.sv.autokart.dtos.AccessoryListResponse;
import com.sv.autokart.models.Accessory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class AccessoryMapper {

    @Mapping(target = "accesoryId", source = "accesoryId")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "imageUrl", source = "imageUrl")
    @Mapping(target = "price", source = "price")
    public abstract AccessoryListResponse mapAccessoriesToDto(Accessory accessory);
}
