package Repository;

import Exceptions.InvalidGateNumberException;
import Models.Gate;

import java.util.HashMap;

public class GateRepository {

    //To get the gate info by gate Id
    HashMap<Integer, Gate> map=new HashMap<>();

    public Gate findGateById(int gateId) throws InvalidGateNumberException {
        if(map.containsKey(gateId)){
            return map.get(gateId);
        }
        else{
            throw new InvalidGateNumberException();
        }
    }


}
