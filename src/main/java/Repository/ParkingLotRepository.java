package Repository;

import Exceptions.ParkingLotNotAvailableException;
import Models.ParkingLot;

import java.util.HashMap;

public class ParkingLotRepository {
    public static HashMap<Integer, ParkingLot> parkingLotRepositoryMap=new HashMap<>();

    public static ParkingLot findParkingLotById(int id) throws ParkingLotNotAvailableException {
        if(parkingLotRepositoryMap.containsKey(id)){
            return parkingLotRepositoryMap.get(id);
        }
        else{
            throw new ParkingLotNotAvailableException();
        }
    }

    public void save(int id,ParkingLot parkingLot){
        parkingLotRepositoryMap.put(id,parkingLot);
    }
}
