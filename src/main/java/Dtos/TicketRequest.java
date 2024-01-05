package Dtos;

import Models.VehicleType;

public class TicketRequest {
    private VehicleType vehicleType;
    private String vehicleNumber;
    private int gateId;
    private int parkingLotId;

    public TicketRequest(VehicleType vehicleType, String vehicleNumber, int gateId, int parkingLotId) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.gateId = gateId;
        this.parkingLotId = parkingLotId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
