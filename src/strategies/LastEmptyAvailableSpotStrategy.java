package strategies;

import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.enums.ParkingFloorStatus;
import models.enums.ParkingSpotStatus;
import models.enums.VehicleType;

import java.util.List;

public class LastEmptyAvailableSpotStrategy implements SpotAllocationStrategy{


    @Override
    public ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) {

        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloorList();

        for(int i=parkingFloorList.size()-1; i>=0; i--){
            if(parkingFloorList.get(i).getParkingFloorStatus().equals(ParkingFloorStatus.AVAILABLE)){
                List<ParkingSpot> parkingSpots = parkingFloorList.get(i).getParkingSpots();
                for(int j=parkingSpots.size()-1; j>=0 ; j--){
                    if(parkingSpots.get(j).getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)){
                        if(parkingSpots.get(j).getAllowedVehicleTypes().contains(vehicleType)) {
                            return parkingSpots.get(j);
                        }
                    }
                }
            }
        }

        return null;
    }
}
