package com.sv.autokart.mapper;

import com.sv.autokart.dtos.UserResponse;
import com.sv.autokart.dtos.UsersListResponse;
import com.sv.autokart.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "role", source = "userRole")
    public abstract UsersListResponse mapUsersToDto(User user);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "role", source = "userRole")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "gender", source = "gender")
    public abstract UserResponse mapUserToDto(User user);
}
