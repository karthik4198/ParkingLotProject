package Repository;

import Exceptions.ParkingLotNotAvailableException;
import Models.ParkingLot;

import java.util.HashMap;

public class ParkingLotRepository {
    HashMap<Integer, ParkingLot> map=new HashMap<>();

    public ParkingLot findParkingLotById(int id) throws ParkingLotNotAvailableException {
        if(map.containsKey(id)){
            return map.get(id);
        }
        else{
            throw new ParkingLotNotAvailableException();
        }
    }
}
