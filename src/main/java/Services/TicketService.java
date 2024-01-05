package Services;

import Dtos.TicketRequest;
import Exceptions.InvalidGateNumberException;
import Exceptions.InvalidVehicleNumber;
import Exceptions.ParkingLotNotAvailableException;
import Exceptions.ParkingSlotFullException;
import Models.*;
import Repository.GateRepository;
import Repository.ParkingLotRepository;
import Repository.VehicleRepository;
import Strategies.ParkingPlaceAllotmentStrategy;
import Strategies.ParkingPlaceAllotmentStrategyFactory;

import java.util.Date;
import java.util.UUID;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;

    public Ticket issueTicket(TicketRequest ticketRequest) throws InvalidGateNumberException, ParkingLotNotAvailableException, ParkingSlotFullException {
        Ticket ticket=new Ticket();
        //Setting the current entry time
        ticket.setCurrentEntryTime(new Date());

        //Setting the gate details
        Gate gate=gateRepository.findGateById(ticketRequest.getGateId());
        ticket.setGate(gate);

        //Setting the vehicle details
        Vehicle vehicle= null;
        try {
            vehicle = vehicleRepository.findVehicleByNumber(ticketRequest.getVehicleNumber());
        } catch (InvalidVehicleNumber e) {
            vehicle = new Vehicle(ticketRequest.getVehicleType(),ticketRequest.getVehicleNumber());
            vehicleRepository.save(ticketRequest.getVehicleNumber(),vehicle);
        }
        ticket.setVehicle(vehicle);

        // Set ParkingSlot
        ParkingLot parkingLot=parkingLotRepository.findParkingLotById(ticketRequest.getParkingLotId());
        ParkingPlaceAllotmentStrategy allotmentStrategy=parkingLot.getAllotmentStrategy();
        ParkingPlaceAllotmentStrategy parkingAllotmentRule=ParkingPlaceAllotmentStrategyFactory.getParkingPlaceAllotmentStrategy(allotmentStrategy);
        ParkingSlots parkingSlots=parkingAllotmentRule.getParkingSlotBasedOnStrategy(ticketRequest.getVehicleType(),ticketRequest.getParkingLotId());
        ticket.setParkingSlots(parkingSlots);

        //
        ticket.setNumber(UUID.randomUUID().toString());

        return ticket;

    }
}
