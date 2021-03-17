package com.sv.autokart.repositories;

import com.sv.autokart.models.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRating, Long> {
    List<UserRating> findAllByAccessoryId(Long accessoryId);

    List<UserRating> findAllByUserId(Long userId);
}
