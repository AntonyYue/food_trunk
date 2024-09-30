package org.example.food_trunk.repository;

import com.example.foodtruck.entity.FoodTruck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {
    // 可以根据需要添加自定义查询方法
}
