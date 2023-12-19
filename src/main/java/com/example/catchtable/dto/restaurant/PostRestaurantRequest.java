package com.example.catchtable.dto.restaurant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class PostRestaurantRequest {

    private String category;
    private String region;
    private String address;
    private String name;
    private String lunchPrice;
    private String dinnerPrice;
    private String phoneNumber;
    private String description;
    private String operatingHour;
    private String regularClosed;
    private Timestamp lunchStart;
    private Timestamp lunchEnd;
    private Timestamp dinnerStart;
    private Timestamp dinnerEnd;
    private String briefInfo;
}
