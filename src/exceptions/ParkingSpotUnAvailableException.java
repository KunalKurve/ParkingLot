package exceptions;

public class ParkingSpotUnAvailableException extends RuntimeException{
    public ParkingSpotUnAvailableException(String message){
        super(message);
    }
}
