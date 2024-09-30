package org.example.food_trunk.controller;

import com.example.foodtruck.dto.FoodTruckDTO;
import com.example.foodtruck.service.FoodTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-trucks")
public class FoodTruckController {

    @Autowired
    private FoodTruckService foodTruckService;

    @GetMapping
    public ResponseEntity<List<FoodTruckDTO>> getAllFoodTrucks() {
        List<FoodTruckDTO> foodTrucks = foodTruckService.getAllFoodTrucks();
        return ResponseEntity.ok(foodTrucks);
    }
    
    // 其他接口可以根据需求添加
}
