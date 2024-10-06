package org.example.food_trunk.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.example.food_trunk.dto.FoodTruckDTO;
import org.example.food_trunk.service.FoodTruckService;
import org.example.food_trunk.util.PagingSlicedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodTruckController {

    @Autowired
    private FoodTruckService foodTruckService;

    @Operation(summary = "Search food trucks by food item with pagination")
    @GetMapping("/foodtrucks")
    public ResponseEntity<PagingSlicedResult<FoodTruckDTO>> searchFoodTrucksByItem(
            @Parameter(description = "Search keyword for food items") @RequestParam String foodItem,
            @Parameter(description = "Page number (starts from 0)", example = "0") @RequestParam(defaultValue = "0") int pageNumber,
            @Parameter(description = "Page size", example = "10") @RequestParam(defaultValue = "10") int pageSize) {

        PagingSlicedResult<FoodTruckDTO> result = foodTruckService.findFoodTrucksByItemWithPagination(foodItem, pageNumber, pageSize);
        return ResponseEntity.ok(result);
    }

}
