package com.ihub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ihub.entity.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {

}
