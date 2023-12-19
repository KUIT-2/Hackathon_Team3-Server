package com.example.catchtable.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetBriefRestaurantResponse {

    private long restaurantId;
    private String imageUrl;
    private String restaurantName;
    private double starCount;
    private String category;
    private String region;
}
