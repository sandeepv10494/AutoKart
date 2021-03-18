package com.sv.autokart.repositories;

import com.sv.autokart.models.Order;
import com.sv.autokart.models.OrderItem;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Collection<OrderItem> findAllByOrder(Order order, Sort sort);
}
