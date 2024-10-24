package com.belnitskii.votingsystem.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "vote_time", nullable = false)
    private LocalDateTime voteTime;

    public Vote() {
    }

    public Vote(User user, Restaurant restaurant, LocalDateTime voteTime) {
        this.user = user;
        this.restaurant = restaurant;
        this.voteTime = voteTime;
    }
}
