package Strategies;

public class ParkingPlaceAllotmentStrategyFactory {
    public static ParkingPlaceAllotmentStrategy getParkingPlaceAllotmentStrategy(ParkingPlaceAllotmentStrategy parkingPlaceAllotmentStrategy){
        return new SimpleAllotmentStrategy();
    }
}
