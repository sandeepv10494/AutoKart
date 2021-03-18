package com.sv.autokart.repositories;

import com.sv.autokart.models.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long> {

}
