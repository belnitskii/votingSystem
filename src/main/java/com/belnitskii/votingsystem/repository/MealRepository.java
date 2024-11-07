package com.belnitskii.votingsystem.repository;

import com.belnitskii.votingsystem.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}