package Models;

public class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;

    public Vehicle(VehicleType typeOfVehicle,String number){
        this.vehicleType=typeOfVehicle;
        this.vehicleNumber=number;
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
}
