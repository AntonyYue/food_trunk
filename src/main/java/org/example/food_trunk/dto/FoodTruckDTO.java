package org.example.food_trunk.dto;

public class FoodTruckDTO {
    private String facilityName;
    private String status;
    private String location;

    // 构造方法、getter、setter

    public FoodTruckDTO(String facilityName, String status, String location) {
        this.facilityName = facilityName;
        this.status = status;
        this.location = location;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
