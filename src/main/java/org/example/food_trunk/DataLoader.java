package org.example.food_trunk;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.example.food_trunk.csv.FoodTruckCsvBean;

import org.example.food_trunk.entity.FoodTruck;
import org.example.food_trunk.mapper.FoodTruckMapper;
import org.example.food_trunk.repository.FoodTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private FoodTruckRepository foodTruckRepository;

    @Autowired
    private FoodTruckMapper foodTruckMapper;

    @Override
    public void run(String... args) throws Exception {
        try (FileReader reader = new FileReader("/Users/mac/Downloads/Mobile_Food_Facility_Permit.csv")) {
            CsvToBean<FoodTruckCsvBean> csvToBean = new CsvToBeanBuilder<FoodTruckCsvBean>(reader)
                    .withType(FoodTruckCsvBean.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<FoodTruckCsvBean> csvBeans = csvToBean.parse();
            List<FoodTruck> foodTrucks = csvBeans.stream()
                    .map(foodTruckMapper::csvToEntity)
                    .toList();
            foodTruckRepository.saveAll(foodTrucks);
        }
    }
}
