package com.example.catchtable.dto;

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
    private String restaurantName;
    private int starCount;
    private String category;
    private String region;
}
