package com.example.catchtable.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity(name = "reservation")
@Getter
@NoArgsConstructor
public class Reservation {

    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long reservationId;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "count_people")
    private Long countPeople;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    public Reservation(Timestamp date, Timestamp time, Long countPeople, Restaurant restaurant) {
        this.date = date;
        this.time = time;
        this.countPeople = countPeople;
        this.restaurant = restaurant;
    }
}
