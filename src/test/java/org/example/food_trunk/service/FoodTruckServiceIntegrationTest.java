package org.example.food_trunk.service;

import org.example.food_trunk.dto.FoodTruckDTO;
import org.example.food_trunk.entity.FoodTruck;
import org.example.food_trunk.repository.FoodTruckRepository;

import org.example.food_trunk.util.PagingSlicedResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FoodTruckServiceIntegrationTest {

    @Autowired
    private FoodTruckService foodTruckService;

    @Autowired
    private FoodTruckRepository foodTruckRepository;

    @BeforeEach
    void setUp() {

        FoodTruck foodTruck = new FoodTruck();
        foodTruck.setFacilityType("Test Facility");
        foodTruck.setStatus("Approved");
        foodTruck.setLocation("Test Location");
        foodTruck.setFoodItems("VeganTest");
        foodTruckRepository.save(foodTruck);
    }

    @Test
    void testFindFoodTrucksByItemWithPagination() {
        PagingSlicedResult<FoodTruckDTO> result = foodTruckService.findFoodTrucksByItemWithPagination("VeganTest", 0, 10);

        assertEquals(1, result.getContent().size());
        assertEquals("Test Facility", result.getContent().get(0).getFacilityType());
    }
}
