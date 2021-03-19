package com.sv.autokart.repositories;

import com.sv.autokart.models.CartItem;
import com.sv.autokart.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    @Query("select w from Wishlist w where w.accessory.accesoryId = :id")
    Optional<Wishlist> findWishlistItemByAccessoryId(Long id);

    List<Wishlist> findAllByUserId(Long userId);
}
