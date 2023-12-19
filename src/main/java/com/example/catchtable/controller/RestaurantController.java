package com.example.catchtable.controller;

import com.example.catchtable.common.response.BaseResponse;
import com.example.catchtable.dto.GetRestaurantImagesResponse;
import com.example.catchtable.dto.GetRestaurantListResponse;

import com.example.catchtable.dto.GetRestaurantMenuResponse;
import com.example.catchtable.dto.restaurant.GetRestaurantResponse;
import com.example.catchtable.dto.review.GetReviewResponse;
import com.example.catchtable.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("")
    public BaseResponse<GetRestaurantListResponse> getRestaurants() {
        return new BaseResponse<>(restaurantService.getRestaurantList());
    }


    @GetMapping("{restaurantId}/menus")
    public BaseResponse<List<GetRestaurantMenuResponse>> getRestaurantMenus(@PathVariable long restaurantId) {
        return new BaseResponse<List<GetRestaurantMenuResponse>>(restaurantService.getMenuList(restaurantId));
    }

    @GetMapping("/{restaurantId}")
    public BaseResponse<GetRestaurantResponse> getRestaurantById(@PathVariable Long restaurantId) {
        return new BaseResponse<>(restaurantService.getRestaurantById(restaurantId));
    }

    @GetMapping("{restaurantId}/reviews")
    public BaseResponse<List<GetReviewResponse>> getRestaurantReviews(@PathVariable Long restaurantId) {
        return new BaseResponse<>(restaurantService.getReviews(restaurantId));
    }

    @GetMapping("/{restaurantId}/images")
    public BaseResponse<List<GetRestaurantImagesResponse>> getRestaurantImages(@PathVariable long restaurantId) {
        return new BaseResponse<List<GetRestaurantImagesResponse>>((restaurantService.getRestaurantImageList(restaurantId)));
    }

}
