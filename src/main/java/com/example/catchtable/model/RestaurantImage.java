package com.example.catchtable.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "restaurant_image")
@Getter
public class RestaurantImage {

    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column(name = "url", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

}

