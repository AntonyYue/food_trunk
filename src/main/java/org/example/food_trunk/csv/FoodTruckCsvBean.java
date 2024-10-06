package org.example.food_trunk.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class FoodTruckCsvBean {

    @CsvBindByName(column = "locationid")
    private Long locationid;

    @CsvBindByName(column = "Applicant")
    private String applicant;

    @CsvBindByName(column = "FacilityType")
    private String facilityType;

    @CsvBindByName(column = "cnn")
    private Long cnn;

    @CsvBindByName(column = "LocationDescription")
    private String locationDescription;

    @CsvBindByName(column = "Address")
    private String address;

    @CsvBindByName(column = "blocklot")
    private String blocklot;

    @CsvBindByName(column = "block")
    private String block;

    @CsvBindByName(column = "lot")
    private String lot;

    @CsvBindByName(column = "permit")
    private String permit;

    @CsvBindByName(column = "Status")
    private String status;

    @CsvBindByName(column = "FoodItems")
    private String foodItems;

    @CsvBindByName(column = "X")
    private Double x;

    @CsvBindByName(column = "Y")
    private Double y;

    @CsvBindByName(column = "Latitude")
    private Double latitude;

    @CsvBindByName(column = "Longitude")
    private Double longitude;

    @CsvBindByName(column = "Schedule")
    private String schedule;

    @CsvBindByName(column = "dayshours")
    private String dayshours;

    @CsvBindByName(column = "NOISent")
    private String noiSent;

    @CsvBindByName(column = "Approved")
    private String approved;

    @CsvBindByName(column = "Received")
    private String received;

    @CsvBindByName(column = "PriorPermit")
    private String priorPermit;

    @CsvBindByName(column = "ExpirationDate")
    private String expirationDate;

    @CsvBindByName(column = "Location")
    private String location;

    @CsvBindByName(column = "Fire Prevention Districts")
    private Integer firePreventionDistricts;

    @CsvBindByName(column = "Police Districts")
    private Integer policeDistricts;

    @CsvBindByName(column = "Supervisor Districts")
    private Integer supervisorDistricts;

    @CsvBindByName(column = "Zip Codes")
    private Integer zipCodes;

    @CsvBindByName(column = "Neighborhoods (old)")
    private Integer neighborhoodsOld;
}
