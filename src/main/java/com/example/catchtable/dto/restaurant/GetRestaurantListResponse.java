package com.example.catchtable.dto.restaurant;

import com.example.catchtable.dto.restaurant.GetBriefRestaurantResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetRestaurantListResponse {

    private List<GetBriefRestaurantResponse> restaurantList;

}
