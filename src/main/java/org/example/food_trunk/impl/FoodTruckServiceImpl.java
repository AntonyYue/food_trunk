package org.example.food_trunk.impl;


import org.example.food_trunk.dto.FoodTruckDTO;
import org.example.food_trunk.mapper.FoodTruckMapper;
import org.example.food_trunk.repository.FoodTruckRepository;
import org.example.food_trunk.service.FoodTruckService;
import org.example.food_trunk.util.PagingSlicedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FoodTruckServiceImpl implements FoodTruckService {

    @Autowired
    private FoodTruckRepository foodTruckRepository;

    @Autowired
    private FoodTruckMapper foodTruckMapper;



    @Override
    public PagingSlicedResult<FoodTruckDTO> findFoodTrucksByItemWithPagination(String foodItem, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<FoodTruckDTO> foodTruckPage = foodTruckRepository
                .findByFoodItemsContainingIgnoreCase(foodItem, pageable)
                .map(foodTruckMapper::entityToDto);

        return new PagingSlicedResult<>(
                foodTruckPage.getContent(),
                foodTruckPage.getNumber(),
                foodTruckPage.getSize(),
                foodTruckPage.getTotalElements()
        );
    }
}
