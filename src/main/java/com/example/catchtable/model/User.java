package com.example.catchtable.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "region")
    private String region;

    public User(String name, String introduction, String region) {
        this.name = name;
        this.introduction = introduction;
        this.region = region;
    }

    public User() {

    }

    //@OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)

}

