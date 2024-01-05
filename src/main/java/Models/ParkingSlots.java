package Models;

public class ParkingSlots {
    private int parkingSlotNumber;
    private VehicleType vehicleType;

    private ParkingSlotStaus parkingSlotStaus;
    private ParkingFloors parkingFloors;

    public int getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public void setParkingSlotNumber(int parkingSlotNumber) {
        this.parkingSlotNumber = parkingSlotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSlotStaus getParkingSlotStaus() {
        return parkingSlotStaus;
    }

    public void setParkingSlotStaus(ParkingSlotStaus parkingSlotStaus) {
        this.parkingSlotStaus = parkingSlotStaus;
    }

    public ParkingFloors getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(ParkingFloors parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
