package models;

import models.enums.ParkingSpotStatus;
import models.enums.VehicleType;

import java.util.Set;

public class ParkingSpot extends BaseEntity{

    private int spotNo;
    // private VehicleType vehicleType;
    // or a Spot for 4 wheeler can also be given to two-wheelers
    private Set<VehicleType> allowedVehicleTypes;
    private ParkingSpotStatus parkingSpotStatus;
    // can add bidirectional relationship between slot and floor
    private ParkingFloor parkingFloor;



    public Set<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(Set<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(int spotNo) {
        this.spotNo = spotNo;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}
