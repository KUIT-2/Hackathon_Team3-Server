package com.example.catchtable.service;

import com.example.catchtable.dto.GetBriefRestaurantResponse;
import com.example.catchtable.dto.GetRestaurantListResponse;
import com.example.catchtable.model.Restaurant;
import com.example.catchtable.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public GetRestaurantListResponse getRestaurantList() {
        List<GetBriefRestaurantResponse> restaurantList = restaurantRepository.findAll()
                .stream()
                .map(restaurant -> new GetBriefRestaurantResponse(
                        restaurant.getRestaurantId(),
                        restaurant.getRestaurantImages().get(0).getUrl(),
                        restaurant.getName(),
                        // 가정: 별점은 별도의 계산 또는 필드를 통해 가져옵니다.
                        calculateStarCount(restaurant),
                        restaurant.getCategory(),
                        restaurant.getRegion()))
                .collect(Collectors.toList());

        return new GetRestaurantListResponse(restaurantList);
    }

    private int calculateStarCount(Restaurant restaurant) {
        // 별점 계산 로직 구현
        return 0; // 임시 반환값
    }
}
