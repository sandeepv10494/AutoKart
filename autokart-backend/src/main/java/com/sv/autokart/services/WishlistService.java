package com.sv.autokart.services;

import com.sv.autokart.dtos.WishlistResponse;
import com.sv.autokart.mapper.WishlistMapper;
import com.sv.autokart.models.Accessory;
import com.sv.autokart.models.Wishlist;
import com.sv.autokart.repositories.AccessoryRepository;
import com.sv.autokart.repositories.WishlistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final AccessoryRepository accessoryRepository;
    private final WishlistMapper wishlistMapper;

    @Transactional(readOnly = true)
    public List<WishlistResponse> getAllWishListItemsForUser(Long userId){
        return wishlistRepository.findAllByUserId(userId).stream().map(wishlistMapper::mapToDto).collect(Collectors.toList());
    }

    @Transactional
    public void toggleWishList(Long accessoryId, Long userId){
        Optional<Wishlist> wishlist = wishlistRepository.findWishlistItemByAccessoryId(accessoryId);

        if(wishlist.isPresent()){
            wishlistRepository.deleteById(wishlist.get().getId());
        }
        else {
            Accessory accessory = accessoryRepository.findById(accessoryId).get();
            Wishlist newWishlistItem = new Wishlist();
            newWishlistItem.setUserId(userId);
            newWishlistItem.setAccessory(accessory);
            wishlistRepository.save(newWishlistItem);
        }
    }
}
