package Strategies;

import Exceptions.ParkingSlotFullException;
import Models.ParkingSlots;
import Models.VehicleType;

public interface ParkingPlaceAllotmentStrategy {
    ParkingSlots getParkingSlotBasedOnStrategy(VehicleType vehicleType,int ParkingLotId) throws ParkingSlotFullException;
}
