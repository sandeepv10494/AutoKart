package com.sv.autokart.repositories;

import com.sv.autokart.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Query("select c from CartItem c where c.accessory.accesoryId = :id")
    Optional<CartItem> findCartItemByAccessoryId(Long id);

    List<CartItem> findAllByUserId(Long userId);
}
