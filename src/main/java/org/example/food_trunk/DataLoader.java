package org.example.food_trunk;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.example.food_trunk.csv.FoodPermit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private FoodPermitRepository foodPermitRepository;

    @Override
    public void run(String... args) throws Exception {
        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("/Mobile_Food_Facility_Permit (1).csv"))) {

            // 使用 CsvToBean 将 CSV 文件映射到实体类
            CsvToBean<FoodPermit> csvToBean = new CsvToBeanBuilder<FoodPermit>(reader)
                    .withType(FoodPermit.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // 解析 CSV 并保存到数据库
            List<FoodPermit> foodPermits = csvToBean.parse();
            foodPermitRepository.saveAll(foodPermits);
        }
    }
}
