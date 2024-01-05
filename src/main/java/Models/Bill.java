package Models;

import java.time.LocalDateTime;
import java.util.List;

public class Bill {
    private Vehicle vehicle;
    private Ticket ticker;
    private LocalDateTime currentExitTime;
    private Gate exitGate;
    private List<Payments> paymentsList;
    private Operator operator;
    private BillStatus billStatus;
    private float billAmount;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Ticket getTicker() {
        return ticker;
    }

    public void setTicker(Ticket ticker) {
        this.ticker = ticker;
    }

    public LocalDateTime getCurrentExitTime() {
        return currentExitTime;
    }

    public void setCurrentExitTime(LocalDateTime currentExitTime) {
        this.currentExitTime = currentExitTime;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public float getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(float billAmount) {
        this.billAmount = billAmount;
    }

    public List<Payments> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<Payments> paymentsList) {
        this.paymentsList = paymentsList;
    }
}
