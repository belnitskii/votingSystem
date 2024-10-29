package com.belnitskii.votingsystem.service;

import com.belnitskii.votingsystem.model.Restaurant;
import com.belnitskii.votingsystem.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;


    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id){
        return restaurantRepository.findById(id).orElse(null);
    }
}
