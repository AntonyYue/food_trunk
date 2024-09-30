package org.example.food_trunk.csv;

import com.opencsv.bean.CsvBindByName;

public class FoodPermit {
    @CsvBindByName(column = "Facility Name")
    private String facilityName;

    @CsvBindByName(column = "Status")
    private String status;

    @CsvBindByName(column = "Location")
    private String location;
}
