package org.example.food_trunk;

import org.example.food_trunk.controller.FoodTruckController;
import org.example.food_trunk.dto.FoodTruckDTO;
import org.example.food_trunk.service.FoodTruckService;
import org.example.food_trunk.util.PagingSlicedResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class FoodTruckControllerTest {

    @Mock
    private FoodTruckService foodTruckService;

    @InjectMocks
    private FoodTruckController foodTruckController;

    private PagingSlicedResult<FoodTruckDTO> pagingSlicedResult;

    @BeforeEach
    void setUp() {
        try (AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this)) {

        FoodTruckDTO foodTruckDTO = new FoodTruckDTO();
        foodTruckDTO.setFacilityType("Test Facility");
        foodTruckDTO.setApproved("Approved");
        foodTruckDTO.setLocation("Test Location");
        pagingSlicedResult = new PagingSlicedResult<>(Collections.singletonList(foodTruckDTO), 0, 10, 1L);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testSearchFoodTrucksByItem() {
        when(foodTruckService.findFoodTrucksByItemWithPagination(anyString(), anyInt(), anyInt()))
                .thenReturn(pagingSlicedResult);

        ResponseEntity<PagingSlicedResult<FoodTruckDTO>> response = foodTruckController.searchFoodTrucksByItem("Vegan", 0, 10);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(1, Objects.requireNonNull(response.getBody()).getContent().size());
        assertEquals("Test Facility", response.getBody().getContent().get(0).getFacilityType());
        verify(foodTruckService, times(1)).findFoodTrucksByItemWithPagination("Vegan", 0, 10);
    }
}
