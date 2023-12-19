package com.example.catchtable.model;

import jakarta.persistence.*;
import lombok.Getter;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "restaurant")
@Getter
@NoArgsConstructor
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

    @Column(name = "brief_info")
    @NotNull
    private String briefInfo;

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

    @Column(name = "lunch_start")
    private Timestamp lunchStart;

    @Column(name = "lunch_end")
    private Timestamp lunchEnd;

    @Column(name = "dinner_start")
    private Timestamp dinnerStart;

    @Column(name = "dinner_end")
    private Timestamp dinnerEnd;

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<RestaurantImage> restaurantImages = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public Restaurant(Long restaurantId, String category, String region, String address, String name, String briefInfo, String lunchPrice, String dinnerPrice, Timestamp lunchStart, Timestamp lunchEnd, Timestamp dinnerStart, Timestamp dinnerEnd) {
        this.restaurantId = restaurantId;
        this.category = category;
        this.region = region;
        this.address = address;
        this.name = name;
        this.briefInfo = briefInfo;
        this.lunchPrice = lunchPrice;
        this.dinnerPrice = dinnerPrice;
        this.lunchStart = lunchStart;
        this.lunchEnd = lunchEnd;
        this.dinnerStart = dinnerStart;
        this.dinnerEnd = dinnerEnd;
    }
}
