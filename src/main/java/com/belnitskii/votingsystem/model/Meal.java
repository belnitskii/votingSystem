package com.belnitskii.votingsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "price", nullable = false)
    private Double price;

    public Meal() {}

    public Meal(String name, Restaurant restaurant, Double price) {
        this.name = name;
        this.restaurant = restaurant;
        this.price = price;
    }
}
