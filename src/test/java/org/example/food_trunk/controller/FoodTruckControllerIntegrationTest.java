package org.example.food_trunk.controller;

import org.example.food_trunk.entity.FoodTruck;
import org.example.food_trunk.repository.FoodTruckRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FoodTruckControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FoodTruckRepository foodTruckRepository;

    @BeforeEach
    void setUp() {
        foodTruckRepository.deleteAll();
        FoodTruck truck1 = new FoodTruck();
        truck1.setApplicant("Truck A");
        truck1.setFoodItems("Noodles, Sandwiches");
        truck1.setAddress("123 Noodle St");
        foodTruckRepository.save(truck1);

        FoodTruck truck2 = new FoodTruck();
        truck2.setApplicant("Truck B");
        truck2.setFoodItems("Burgers, Fries");
        truck2.setAddress("456 Burger Rd");
        foodTruckRepository.save(truck2);
    }

    @Test
    public void testGetFoodTrucksWithPaginationAndFilter() throws Exception {
        mockMvc.perform(get("/api/foodtrucks")
                        .param("foodItem", "Noodles")
                        .param("pageNumber", "0")
                        .param("pageSize", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content", hasSize(1)))  // Expect one food truck with Noodles
                .andExpect(jsonPath("$.content[0].applicant").value("Truck A"))
                .andExpect(jsonPath("$.content[0].foodItems").value("Noodles, Sandwiches"));
    }


}
