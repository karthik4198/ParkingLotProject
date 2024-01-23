package Models;

import java.util.List;

public class ParkingFloors {
    private int floorNumber;
    private List<ParkingSlots> parkingSlotsList;
    private ParkingFloorStatus parkingFloorStatus;

    public ParkingFloors(int floorNumber,List<ParkingSlots> parkingSlotsList,ParkingFloorStatus parkingFloorStatus){
        this.floorNumber=floorNumber;
        this.parkingSlotsList=parkingSlotsList;
        this.parkingFloorStatus=parkingFloorStatus;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlots> getParkingSlotsList() {
        return parkingSlotsList;
    }

    public void setParkingSlotsList(List<ParkingSlots> parkingSlotsList) {
        this.parkingSlotsList = parkingSlotsList;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }
}
