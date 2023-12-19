package com.example.catchtable.service;

import com.example.catchtable.dto.GetBriefRestaurantResponse;
import com.example.catchtable.dto.GetRestaurantImagesResponse;
import com.example.catchtable.dto.GetRestaurantListResponse;

import com.example.catchtable.dto.GetRestaurantMenuResponse;
import com.example.catchtable.dto.menu.MenuDto;
import com.example.catchtable.dto.restaurant.GetRestaurantResponse;
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

    public GetRestaurantResponse getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        List<String> restaurantImages = restaurant.getRestaurantImages()
                .stream()
                .map(restaurantImage -> restaurantImage.getUrl())
                .collect(Collectors.toList());

        List<MenuDto> menuList = restaurant.getMenus()
                .stream()
                .map(menu -> new MenuDto(menu.getName(), menu.getPrice()))
                .collect(Collectors.toList());

        return new GetRestaurantResponse(
                restaurantImages,
                restaurant.getCategory(),
                restaurant.getRegion(),
                restaurant.getName(),
                calculateStarCount(restaurant),
                restaurant.getBriefInfo(),
                restaurant.getLunchPrice(),
                restaurant.getDinnerPrice(),
                menuList,
                restaurant.getAddress(),
                restaurant.getPhoneNumber(),
                restaurant.getDescription(),
                restaurant.getOperatingHour(),
                restaurant.getRegularClosed()
        );
    }

    private int calculateStarCount(Restaurant restaurant) {
        // 별점 계산 로직 구현
        return 0; // 임시 반환값
    }


   public List<GetRestaurantMenuResponse> getMenuList(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).
                orElseThrow(() -> new RuntimeException("Restaurant not found"));

        return restaurant.getMenus().stream()
                .map(menu -> new GetRestaurantMenuResponse(
                        menu.getName(),
                        menu.getPrice()))
                .collect(Collectors.toList());
    }

    public List<GetRestaurantImagesResponse> getRestaurantImageList(long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).
                orElseThrow(() -> new RuntimeException("Restaurant not found"));

        return restaurant.getRestaurantImages().stream()
                .map(image -> new GetRestaurantImagesResponse(image.getUrl()))
                .collect(Collectors.toList());
    }
}

