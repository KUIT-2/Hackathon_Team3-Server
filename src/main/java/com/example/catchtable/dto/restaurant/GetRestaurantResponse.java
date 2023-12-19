package com.example.catchtable.dto.restaurant;

import com.example.catchtable.dto.menu.MenuDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetRestaurantResponse {
    private List<String> restaurantImages;
    private String category;
    private String region;
    private String name;
    private double rating;
    private String briefInfo;
    private String lunchPrice;
    private String dinnerPrice;
    private List<MenuDto> menuList;
    private String address;
    private String phoneNumber;
    private String description;
    private String operatingHour;
    private String regularClosed;
}
