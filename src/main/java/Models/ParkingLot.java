package Models;

import Strategies.ParkingPlaceAllotmentStrategy;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloors> parkingFloorsList;
    private ParkingLotStatus parkingLotStatus;
    private List<Gate> gateList;

    private ParkingPlaceAllotmentStrategy allotmentStrategy;

    public List<ParkingFloors> getParkingFloorsList() {
        return parkingFloorsList;
    }

    public void setParkingFloorsList(List<ParkingFloors> parkingFloorsList) {
        this.parkingFloorsList = parkingFloorsList;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<Gate> getGateList() {
        return gateList;
    }

    public void setGateList(List<Gate> gateList) {
        this.gateList = gateList;
    }

    public ParkingPlaceAllotmentStrategy getAllotmentStrategy() {
        return allotmentStrategy;
    }

    public void setAllotmentStrategy(ParkingPlaceAllotmentStrategy allotmentStrategy) {
        this.allotmentStrategy = allotmentStrategy;
    }
}
