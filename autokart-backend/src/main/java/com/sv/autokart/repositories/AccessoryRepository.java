package com.sv.autokart.repositories;

import com.sv.autokart.models.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long> {

    @Query("select a from Accessory a where a.categories.categoryName = :categoryName")
    List<Accessory> findAllByCategoryName(String categoryName);
}
