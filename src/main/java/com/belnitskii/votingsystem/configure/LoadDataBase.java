package com.belnitskii.votingsystem.configure;

import com.belnitskii.votingsystem.model.Meal;
import com.belnitskii.votingsystem.model.Restaurant;
import com.belnitskii.votingsystem.model.User;
import com.belnitskii.votingsystem.model.Vote;
import com.belnitskii.votingsystem.repository.MealRepository;
import com.belnitskii.votingsystem.repository.RestaurantRepository;
import com.belnitskii.votingsystem.repository.UserRepository;
import com.belnitskii.votingsystem.repository.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDataBase(UserRepository userRepository, RestaurantRepository restaurantRepository, MealRepository mealRepository, VoteRepository voteRepository) {
        return args -> {
            restaurantRepository.save(new Restaurant("Fish and Chips"));
            restaurantRepository.save(new Restaurant("Beer House"));
            restaurantRepository.findAll().forEach(restaurant -> log.info("Preloaded{}", restaurant));

            userRepository.save(new User("Alex", "example@gmail.com"));
            userRepository.save(new User("Bob", "bob@gmail.com"));
            userRepository.findAll().forEach(user -> log.info("Preloaded {}", user));

            mealRepository.save(new Meal("Fish", restaurantRepository.findByName("Fish and Chips"), 3.5));
            mealRepository.save(new Meal("Vine", restaurantRepository.findByName("Fish and Chips"), 2.0));
            mealRepository.save(new Meal("Meat", restaurantRepository.findByName("Beer House"), 5.0));
            mealRepository.save(new Meal("Beer", restaurantRepository.findByName("Beer House"), 1.5));
            mealRepository.findAll().forEach(meal -> log.info("Preloaded {}", meal));

            voteRepository.save(new Vote(userRepository.findByName("Alex"), restaurantRepository.findByName("Fish and Chips"), LocalDateTime.now()));
            voteRepository.save(new Vote(userRepository.findByName("Bob"), restaurantRepository.findByName("Beer House"), LocalDateTime.now()));
            voteRepository.findAll().forEach(vote -> log.info("Preloaded{}", vote));
        };
    }
}
