package strategies;

import models.enums.VehicleType;

public class SpotAllocationStrategyFactory {

    private final static NearestAvailableSpotStrategy nearestAvailableSpotStrategy = new NearestAvailableSpotStrategy();
    private final static LastEmptyAvailableSpotStrategy lastEmptyAvailableSpotStrategy = new LastEmptyAvailableSpotStrategy();

    public static SpotAllocationStrategy assignSpotStrategy(SpotAllocationStrategyType spotAllocationStrategyType){
        return switch (spotAllocationStrategyType){

            case NEAREST_AVAILABLE -> nearestAvailableSpotStrategy;

            case LAST_EMPTY -> lastEmptyAvailableSpotStrategy;
        };

    }

}
