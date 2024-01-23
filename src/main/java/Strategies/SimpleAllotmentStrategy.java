package Strategies;

import Exceptions.ParkingLotNotAvailableException;
import Exceptions.ParkingSlotFullException;
import Models.*;
import Repository.ParkingLotRepository;

import java.util.List;

public class SimpleAllotmentStrategy implements ParkingPlaceAllotmentStrategy{
    @Override
    public ParkingSlots getParkingSlotBasedOnStrategy(VehicleType vehicleType, int ParkingLotId) throws ParkingSlotFullException, ParkingLotNotAvailableException {
            ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
            ParkingLot parkingLot = parkingLotRepository.findParkingLotById(ParkingLotId);
            List<ParkingFloors> parkingFloorList = parkingLot.getParkingFloorsList();
            for (int i = 0; i < parkingFloorList.size(); i++) {
                ParkingFloors parkingFloors = parkingFloorList.get(i);
                List<ParkingSlots> parkingSlotsList = parkingFloors.getParkingSlotsList();
                for (int j = 0; j < parkingSlotsList.size(); j++) {
                    if (parkingSlotsList.get(j).getParkingSlotStaus() == ParkingSlotStaus.VACANT) {
                        return parkingSlotsList.get(j);
                    }
                }
            }
            return null;
    }
}
