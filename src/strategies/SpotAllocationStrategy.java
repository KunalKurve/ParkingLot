package strategies;

import models.ParkingLot;
import models.ParkingSpot;
import models.enums.VehicleType;

public interface SpotAllocationStrategy {

    ParkingSpot assignSpot(ParkingLot parkingLot,VehicleType vehicleType);
}
