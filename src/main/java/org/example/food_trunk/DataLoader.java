package org.example.food_trunk;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.example.food_trunk.csv.FoodTruckCsvBean;

import org.example.food_trunk.entity.FoodTruck;
import org.example.food_trunk.mapper.FoodTruckMapper;
import org.example.food_trunk.repository.FoodTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private FoodTruckRepository foodTruckRepository;

    @Autowired
    private FoodTruckMapper foodTruckMapper;

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void run(String... args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:Mobile_Food_Facility_Permit.csv");
        try (Reader reader = new InputStreamReader(resource.getInputStream())) {
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
