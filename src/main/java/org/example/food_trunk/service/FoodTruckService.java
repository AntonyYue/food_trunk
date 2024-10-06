package org.example.food_trunk.service;

import org.example.food_trunk.dto.FoodTruckDTO;
import org.example.food_trunk.util.PagingSlicedResult;



public interface FoodTruckService {

    PagingSlicedResult<FoodTruckDTO> findFoodTrucksByItemWithPagination(String foodItem, int pageNumber, int pageSize);
}