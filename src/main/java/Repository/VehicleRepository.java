package Repository;

import Exceptions.InvalidVehicleNumber;
import Models.Vehicle;

import java.util.HashMap;

public class VehicleRepository {

    HashMap<String,Vehicle> map=new HashMap<>();
    public Vehicle findVehicleByNumber(String vehicleNumber) throws InvalidVehicleNumber {
        if (map.containsKey(vehicleNumber)) {
            return map.get(vehicleNumber);
        }
        else{
            throw new InvalidVehicleNumber();
        }
    }

    public void save(String vehicleNumber,Vehicle vehicle) {
        map.put(vehicleNumber,vehicle);
    }
}
