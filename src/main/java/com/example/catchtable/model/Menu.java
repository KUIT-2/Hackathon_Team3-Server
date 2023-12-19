package com.example.catchtable.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "menu")
@NoArgsConstructor
@Getter
public class Menu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long menuId;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "price")
    @NotNull
    private Long price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
