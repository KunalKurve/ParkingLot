package models;

import models.enums.ParkingLotStatus;
import strategies.*;

import java.util.List;

public class ParkingLot extends BaseEntity{

    private String address;
    private City city;
    private List<ParkingFloor> parkingFloorList;
    private List<Gate> gates;
    private SpotAllocationStrategy spotAllocationStrategy;
    private PricingStrategy pricingStrategy;
    private ParkingLotStatus parkingLotStatus;

    /*
     Wrong
     private SpotAllocationStrategyType spotAllocationStrategyType;
     private PricingStrategyType pricingStrategyType;
    */

    public ParkingLot(PricingStrategyType pricingStrategyType, SpotAllocationStrategyType spotAllocationStrategyType){
        this.pricingStrategy = PricingStrategyFactory.getPricingStrategy(pricingStrategyType);
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public SpotAllocationStrategy getSpotAllocationStrategy() {
        return spotAllocationStrategy;
    }

    public void setSpotAllocationStrategy(SpotAllocationStrategy spotAllocationStrategy) {
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
}
