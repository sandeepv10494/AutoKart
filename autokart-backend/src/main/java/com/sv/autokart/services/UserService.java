package com.sv.autokart.services;

import com.sv.autokart.dtos.UserResponse;
import com.sv.autokart.dtos.UsersListResponse;
import com.sv.autokart.exceptions.SpringAutoKartException;
import com.sv.autokart.mapper.UserMapper;
import com.sv.autokart.models.User;
import com.sv.autokart.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper usersMapper;

    @Transactional(readOnly = true)
    public List<UsersListResponse> getAllUsers(){
        return userRepository.findAll().stream().map(usersMapper::mapUsersToDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserResponse getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(()->new SpringAutoKartException(id.toString()));
        return usersMapper.mapUserToDto(user);
    }

}
