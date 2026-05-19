package models;

import strategies.PricingStrategy;

import java.util.Date;

public class Ticket extends BaseEntity{

    private Date entryTime;
    private Vehicle vehicle;
    private Gate entryGate;
    private Operator operator;
    private ParkingSpot assignedParkingSpot;
    // due to bidirectional relationship I can fetch Floor
    private PricingStrategy pricingStrategy;
    // decided at start so vimp to keep, otherwise fight can happen


// Getter and Setters

    public ParkingSpot getAssignedParkingSpot() {
        return assignedParkingSpot;
    }

    public void setAssignedParkingSpot(ParkingSpot parkingSpot) {
        this.assignedParkingSpot = parkingSpot;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
}
