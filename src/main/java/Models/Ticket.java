package Models;

import java.util.Date;

public class Ticket {
    private String number;
    private Vehicle vehicle;
    private Date currentEntryTime;
    private Gate gate;
    private Operator operator;

    private ParkingFloors parkingFloors;
    private ParkingSlots parkingSlots;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public ParkingSlots getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(ParkingSlots parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public Date getCurrentEntryTime() {
        return currentEntryTime;
    }

    public void setCurrentEntryTime(Date currentEntryTime) {
        this.currentEntryTime = currentEntryTime;
    }

    public ParkingFloors getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(ParkingFloors parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
