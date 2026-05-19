package models;

import models.enums.ParkingFloorStatus;

import java.util.List;

public class ParkingFloor extends BaseEntity{

    private Long floorNo; // can also be Enum
    private List<ParkingSpot> parkingSpots;
    private ParkingFloorStatus parkingFloorStatus;


    public Long getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Long floorNo) {
        this.floorNo = floorNo;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
