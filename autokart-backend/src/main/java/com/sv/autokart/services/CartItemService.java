package com.sv.autokart.services;

import com.sv.autokart.dtos.CartItemListResponse;
import com.sv.autokart.dtos.CartItemRequest;
import com.sv.autokart.exceptions.SpringAutoKartException;
import com.sv.autokart.mapper.CartItemMapper;
import com.sv.autokart.models.Accessory;
import com.sv.autokart.models.CartItem;
import com.sv.autokart.repositories.AccessoryRepository;
import com.sv.autokart.repositories.CartItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final AccessoryRepository accessoryRepository;
    private final CartItemMapper cartItemMapper;

    @Transactional(readOnly = true)
    public List<CartItemListResponse> getAllCartItemForUser(Long userId){
        return cartItemRepository.findAllByUserId(userId).stream().map(cartItemMapper::mapToDto).collect(Collectors.toList());
    }

    @Transactional
    public void saveCartItem(CartItemRequest cartItemRequest){
        Accessory accessory = accessoryRepository.findById(cartItemRequest.getAccessoryId()).orElseThrow(()->new SpringAutoKartException("Accessory not found"));

        Long price = accessory.getPrice() * cartItemRequest.getQuantity();

        CartItem cartItem = new CartItem();
        cartItem.setUserId(cartItemRequest.getUserId());
        cartItem.setQuantity(cartItemRequest.getQuantity());
        cartItem.setPrice(price);
        cartItem.setAccessory(accessory);

        cartItemRepository.save(cartItem);
    }

    @Transactional
    public void updateCartItem(Long cartItemId, Long quantity){
        CartItem cartItem = cartItemRepository.findById(cartItemId).get();
        Long cartItemQuantity = cartItem.getQuantity() + quantity;
        Long price = cartItem.getAccessory().getPrice() * cartItemQuantity;
        cartItem.setQuantity(cartItemQuantity);
        cartItem.setPrice(price);
        cartItemRepository.save(cartItem);
    }

    @Transactional
    public void deleteCartItem(Long cartItemId){
        cartItemRepository.deleteById(cartItemId);
    }
}
