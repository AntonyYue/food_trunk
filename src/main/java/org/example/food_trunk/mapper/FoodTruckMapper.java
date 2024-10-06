package org.example.food_trunk.mapper;


import org.example.food_trunk.csv.FoodTruckCsvBean;
import org.example.food_trunk.dto.FoodTruckDTO;
import org.example.food_trunk.entity.FoodTruck;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodTruckMapper {



    // CSV Bean to Entity
    FoodTruck csvToEntity(FoodTruckCsvBean csvBean);



    // Entity to DTO
    FoodTruckDTO entityToDto(FoodTruck foodTruck);


}
