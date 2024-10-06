package org.example.food_trunk.repository;


import org.example.food_trunk.entity.FoodTruck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {

    Page<FoodTruck> findByFoodItemsContainingIgnoreCase(String foodItems, Pageable pageable);
}
