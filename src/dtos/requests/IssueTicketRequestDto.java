package dtos.requests;

import models.enums.VehicleType;

public class IssueTicketRequestDto {

    private int gateId;
    private String numberPlate;
    private VehicleType vehicleType;
    private String driverPhoneNumber;
    private String driverName;
    private int parkingLotId;

    public IssueTicketRequestDto(int gateId,
                                 String numberPlate,
                                 VehicleType vehicleType,
                                 String driverPhoneNumber,
                                 String driverName,
                                 int parkingLotId) {
        this.gateId = gateId;
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
        this.driverPhoneNumber = driverPhoneNumber;
        this.driverName = driverName;
        this.parkingLotId = parkingLotId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}

