package org.example.food_trunk.util;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.example.food_trunk.entity.FoodTruck;

import java.io.Reader;
import java.util.List;

public class CsvParserUtil {

    public static List<FoodTruck> parseCsvToFoodTrucks(Reader reader) {
        CsvToBean<FoodTruck> csvToBean = new CsvToBeanBuilder<FoodTruck>(reader)
                .withType(FoodTruck.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvToBean.parse();
    }
}
