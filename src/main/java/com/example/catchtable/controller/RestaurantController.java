package com.example.catchtable.controller;

import com.example.catchtable.common.response.BaseResponse;
import com.example.catchtable.dto.GetRestaurantListResponse;
import com.example.catchtable.dto.restaurant.GetRestaurantResponse;
import com.example.catchtable.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("")
    public BaseResponse<GetRestaurantListResponse> getRestaurants() {
        return new BaseResponse<>(restaurantService.getRestaurantList());
    }

    @GetMapping("/{restaurantId}")
    public BaseResponse<GetRestaurantResponse> getRestaurantById(@PathVariable Long restaurantId) {
        return new BaseResponse<>(restaurantService.getRestaurantById(restaurantId));
    }
}
