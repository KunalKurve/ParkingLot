package repositories;

import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {

    private final Map<Integer, ParkingLot> parkingLotMap;
    private static int countId = 0;

    public ParkingLotRepository(){
        this.parkingLotMap = new HashMap<>();
    }

    public Optional<ParkingLot> findById(int parkingLotId){
        if(parkingLotMap.containsKey(parkingLotId)){
            return Optional.of(parkingLotMap.get(parkingLotId));
        }
        return Optional.empty();
    }

    public ParkingLot save(ParkingLot parkingLot){
        if(parkingLot.getId() == 0){
            parkingLot.setId(++countId);
        }
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }
}
