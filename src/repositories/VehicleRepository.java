package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {

    // this is our database, and we cannot keep vehicle number plate as our PK
    private final Map<Integer, Vehicle> savedVehicles;
    private static int countId = 0;

    public VehicleRepository(){
        this.savedVehicles = new HashMap<>();
    }

    public Optional<Vehicle> findByNumberPlateAndPhoneNumber(String numberPlate, String phoneNumber){
        for(Vehicle vehicle : savedVehicles.values()){
            if(vehicle.getVehicleRegistrationNumber().equalsIgnoreCase(numberPlate)
            && vehicle.getPhoneNumber().equalsIgnoreCase(phoneNumber)){
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle){
        if(vehicle.getId() == 0){
            vehicle.setId(++countId);
        }
        savedVehicles.put(vehicle.getId(), vehicle);
        return vehicle;
    }
}
