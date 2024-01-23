package Models;

import Strategies.ParkingPlaceAllotmentStrategy;
import Strategies.ParkingPlaceAllotmentStrategyFactory;

import java.util.List;

public class ParkingLot {
    private int parkingLotNumber;
    private List<ParkingFloors> parkingFloorsList;
    private ParkingLotStatus parkingLotStatus;
    private List<Gate> gateList;

    private ParkingPlaceAllotmentStrategy allotmentStrategy;

    public ParkingLot(int parkingLotNumber, List<ParkingFloors> parkingFloorsList, ParkingLotStatus parkingLotStatus, List<Gate> gateList){
        this.parkingLotNumber=parkingLotNumber;
        this.parkingFloorsList=parkingFloorsList;
        this.parkingLotStatus=parkingLotStatus;
        this.gateList=gateList;
    }

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

    public int getParkingLotNumber() {
        return parkingLotNumber;
    }

    public void setParkingLotNumber(int parkingLotNumber) {
        this.parkingLotNumber = parkingLotNumber;
    }
}
