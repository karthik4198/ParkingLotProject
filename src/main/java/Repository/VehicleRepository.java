package Repository;

import Exceptions.InvalidVehicleNumber;
import Models.Vehicle;

import java.util.HashMap;

public class VehicleRepository {

    static HashMap<String,Vehicle> map=new HashMap<>();
    public static Vehicle findVehicleByNumber(String vehicleNumber) throws InvalidVehicleNumber {
        if (map.containsKey(vehicleNumber)) {
            return map.get(vehicleNumber);
        }
        else{
            throw new InvalidVehicleNumber();
        }
    }

    public static void save(String vehicleNumber,Vehicle vehicle) {
        map.put(vehicleNumber,vehicle);
    }
}
