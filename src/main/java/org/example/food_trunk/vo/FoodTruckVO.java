package org.example.food_trunk.vo;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class FoodTruckVO {


    private Long locationid;
    private String applicant;
    private String facilityType;
    private Long cnn;
    private String locationDescription;
    private String address;
    private String blocklot;
    private String block;
    private String lot;
    private String permit;
    private String status;

    @Column(name = "food_items", columnDefinition = "TEXT")
    private String foodItems;
    private Double x;
    private Double y;
    private Double latitude;
    private Double longitude;
    private String schedule;
    private String dayshours;
    private String noiSent;
    private String approved;
    private String received;
    private String priorPermit;
    private String expirationDate;
    private String location;
    private Integer firePreventionDistricts;
    private Integer policeDistricts;
    private Integer supervisorDistricts;
    private Integer zipCodes;
    private Integer neighborhoodsOld;
}
