package com.sv.autokart.services;

import com.sv.autokart.dtos.UserRatingRequest;
import com.sv.autokart.models.UserRating;
import com.sv.autokart.repositories.UserRatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserRatingService {
    private final UserRatingRepository userRatingRepository;
    private final AuthService authService;

    @Transactional
    public void saveRating(UserRatingRequest userRatingRequest){
        UserRating userRating = new UserRating();
        userRating.setRating(userRatingRequest.getRating());
        userRating.setAccessoryId(userRatingRequest.getAccessoryId());
        userRating.setCommentTitle(userRatingRequest.getCommentTitle());
        userRating.setCommentDescription(userRatingRequest.getCommentDescription());
        userRating.setUserId(authService.getCurrentUser().getUserId());
        userRating.setCommentedBy((authService.getCurrentUser().getFirstName()+authService.getCurrentUser().getLastName()));
        userRatingRepository.save(userRating);
    }

    @Transactional(readOnly = true)
    public List<UserRating> getRatingsForAccessory(Long accessoryId){
        return userRatingRepository.findAllByAccessoryId(accessoryId);
    }

    @Transactional(readOnly = true)
    public List<UserRating> getRatingsByUser(Long userId){
        return userRatingRepository.findAllByUserId(userId);
    }
}
