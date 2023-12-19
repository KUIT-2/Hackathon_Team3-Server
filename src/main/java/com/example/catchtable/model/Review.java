package com.example.catchtable.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Entity
@Table(name = "review")
@Getter
public class Review {

    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "is_revisit", nullable = false)
    private Boolean isRevisit;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "date")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    // Constructors, getters and setters
}

