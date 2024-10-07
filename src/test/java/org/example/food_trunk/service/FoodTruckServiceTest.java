package org.example.food_trunk.service;

import org.example.food_trunk.dto.FoodTruckDTO;
import org.example.food_trunk.entity.FoodTruck;
import org.example.food_trunk.impl.FoodTruckServiceImpl;
import org.example.food_trunk.mapper.FoodTruckMapper;
import org.example.food_trunk.repository.FoodTruckRepository;

import org.example.food_trunk.util.PagingSlicedResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
class FoodTruckServiceTest {

    @Mock
    private FoodTruckRepository foodTruckRepository;

    @Mock
    private FoodTruckMapper foodTruckMapper;

    @InjectMocks
    private FoodTruckServiceImpl foodTruckService;

    private FoodTruck foodTruck;
    private FoodTruckDTO foodTruckDTO;
    private Page<FoodTruck> foodTruckPage;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);

        foodTruck = new FoodTruck();
        foodTruck.setFacilityType("Test Facility");
        foodTruck.setStatus("Approved");
        foodTruck.setLocation("Test Location");
        foodTruck.setFoodItems("Vegan");

        foodTruckDTO = new FoodTruckDTO();
        foodTruckDTO.setFacilityType("Test Facility");
        foodTruckDTO.setStatus("Approved");
        foodTruckDTO.setLocation("Test Location");
        foodTruckDTO.setFoodItems("Vegan");
        foodTruckPage = new PageImpl<>(Collections.singletonList(foodTruck));
    }

    @AfterEach
    void tearDown() throws Exception {
        if (autoCloseable != null) {
            autoCloseable.close(); // 关闭资源
        }
    }

    @Test
    void testFindFoodTrucksByItemWithPagination() {
        Pageable pageable = PageRequest.of(0, 10);
        when(foodTruckRepository.findByFoodItemsContainingIgnoreCase(anyString(), eq(pageable)))
                .thenReturn(foodTruckPage);
        when(foodTruckMapper.entityToDto(foodTruck)).thenReturn(foodTruckDTO);

        PagingSlicedResult<FoodTruckDTO> result = foodTruckService.findFoodTrucksByItemWithPagination("Juice",0,10);

        assertEquals(1, result.getContent().size());
        assertEquals("Test Facility", result.getContent().get(0).getFacilityType());

        verify(foodTruckRepository, times(1)).findByFoodItemsContainingIgnoreCase("Juice", pageable);
    }
}
