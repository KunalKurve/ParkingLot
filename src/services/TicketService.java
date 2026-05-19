package services;

import exceptions.InvalidGateException;
import exceptions.InvalidParkingLotException;
import exceptions.ParkingSpotUnAvailableException;
import models.*;
import models.enums.ParkingSpotStatus;
import models.enums.VehicleType;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategies.*;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private final ParkingLotRepository parkingLotRepository;
    private final VehicleRepository vehicleRepository;
    private final GateRepository gateRepository;
    private final SpotAllocationStrategyType spotAllocationStrategyType;
    private final PricingStrategyType pricingStrategyType;
    private final TicketRepository ticketRepository;

    public TicketService(
            ParkingLotRepository parkingLotRepository,
            VehicleRepository vehicleRepository,
            GateRepository gateRepository,
            SpotAllocationStrategyType spotAllocationStrategyType,
            PricingStrategyType pricingStrategyType,
            TicketRepository ticketRepository
    ){
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository = vehicleRepository;
        this.gateRepository = gateRepository;
        this.spotAllocationStrategyType = spotAllocationStrategyType;
        this.pricingStrategyType = pricingStrategyType;
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(int parkingLotId,
                               int gateId,
                               String numberPlate,
                               VehicleType vehicleType,
                               String driverPhoneNumber,
                               String driverName) {

        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findById(parkingLotId);
        if(optionalParkingLot.isEmpty()){
            throw new InvalidParkingLotException("Invalid Parking Lot Exception");
        }
        ParkingLot parkingLot = optionalParkingLot.get();

        Gate gate = gateRepository.findById(gateId)
                .orElseThrow(()-> new InvalidGateException("Gate does not exist"));

        Optional<Vehicle> optionalVehicle = vehicleRepository.
                findByNumberPlateAndPhoneNumber(numberPlate, driverPhoneNumber);
        Vehicle vehicle = null;
        if(optionalVehicle.isPresent()){
            vehicle = optionalVehicle.get();
        }
        else{
            vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(driverName);
            vehicle.setVehicleRegistrationNumber(numberPlate);
            vehicle.setPhoneNumber(driverPhoneNumber);
            vehicle = vehicleRepository.save(vehicle);
        }

        ParkingSpot parkingSpot = SpotAllocationStrategyFactory.
                assignSpotStrategy(spotAllocationStrategyType).assignSpot(parkingLot, vehicleType);

        if(parkingSpot == null){
            throw new ParkingSpotUnAvailableException("No Spot available");
        }

        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);

        PricingStrategy pricingStrategy = PricingStrategyFactory.
                getPricingStrategy(pricingStrategyType);

        Ticket ticket = new Ticket();
        ticket.setAssignedParkingSpot(parkingSpot);
        ticket.setEntryGate(gate);
        ticket.setOperator(gate.getCurrentOperator());
        ticket.setVehicle(vehicle);
        ticket.setCreatedAt(new Date());
        ticket.setEntryTime(new Date());
        ticket.setPricingStrategy(pricingStrategy);

        return ticketRepository.save(ticket);
    }
}
