package Strategies;

import Exceptions.ParkingSlotFullException;
import Models.ParkingLot;
import Models.ParkingSlots;
import Models.VehicleType;
import Repository.ParkingLotRepository;

public class SimpleAllotmentStrategy implements ParkingPlaceAllotmentStrategy{
    @Override
    public ParkingSlots getParkingSlotBasedOnStrategy(VehicleType vehicleType, int ParkingLotId) throws ParkingSlotFullException {
        //go through all floors in parking lot and assign which is empty
        return null;
    }
}
