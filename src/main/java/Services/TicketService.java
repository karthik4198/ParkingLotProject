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

import javax.sound.midi.Soundbank;
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
        Gate gate=GateRepository.findGateById(ticketRequest.getGateId());
        ticket.setGate(gate);

        //Setting the vehicle details
        Vehicle vehicle= null;
        try {
            vehicle = VehicleRepository.findVehicleByNumber(ticketRequest.getVehicleNumber());
        } catch (InvalidVehicleNumber e) {
            vehicle = new Vehicle(ticketRequest.getVehicleType(),ticketRequest.getVehicleNumber());
            VehicleRepository.save(ticketRequest.getVehicleNumber(),vehicle);
        }
        ticket.setVehicle(vehicle);

        // Set ParkingSlot
        ParkingLot parkingLot=ParkingLotRepository.findParkingLotById(ticketRequest.getParkingLotId());
        ParkingPlaceAllotmentStrategy allotmentStrategy=parkingLot.getAllotmentStrategy();
        ParkingPlaceAllotmentStrategy parkingAllotmentRule=ParkingPlaceAllotmentStrategyFactory.getParkingPlaceAllotmentStrategy(allotmentStrategy);
        ParkingSlots parkingSlots=parkingAllotmentRule.getParkingSlotBasedOnStrategy(ticketRequest.getVehicleType(),ticketRequest.getParkingLotId());
        if(parkingSlots == null){
            throw new ParkingSlotFullException();
        }
        ticket.setParkingSlots(parkingSlots);
        ticket.setParkingFloors(parkingSlots.getParkingFloors());

        // Set Ticket Unique number
        ticket.setNumber(UUID.randomUUID().toString());

        return ticket;

    }
}
