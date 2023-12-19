package com.example.catchtable.model;

import jakarta.persistence.*;
import lombok.Getter;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "restaurant")
@NoArgsConstructor
@Getter
public class Restaurant {

    @Id
    @Column(name = "restaurant_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long restaurantId;

    @Column(name = "category")
    @NotNull
    private String category;

    @Column(name = "region")
    @NotNull
    private String region;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "lunch_price")
    @NotNull
    private String lunchPrice;

    @Column(name = "dinner_price")
    @NotNull
    private String dinnerPrice;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "operating_hour")
    private String operatingHour;

    @Column(name = "regular_closed")
    private String regularClosed;

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<RestaurantImage> restaurantImages = new ArrayList<>();


    public Restaurant(Long restaurant_id, String category, String region, String address, String name, String lunch_price, String dinner_price) {
        this.restaurantId = restaurant_id;
        this.category = category;
        this.region = region;
        this.address = address;
        this.name = name;
        this.lunchPrice= lunch_price;
        this.dinnerPrice = dinner_price;
    }
}
