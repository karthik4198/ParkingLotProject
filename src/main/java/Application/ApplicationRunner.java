package Application;

import Controllers.TicketController;
import Dtos.TicketRequest;
import Dtos.TicketResponse;
import Exceptions.ParkingLotNotAvailableException;
import Models.*;
import Repository.GateRepository;
import Repository.ParkingLotRepository;
import Strategies.ParkingPlaceAllotmentStrategy;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRunner {
    public static void main(String[] args) {
        //Number of floors
        int noOfFloors=2;
        List<ParkingFloors> parkingFloorsList=new ArrayList<>();
        //Number of slots
        int noOfParkingSlots=2;

        for(int i=0;i<noOfFloors;i++){
            List<ParkingSlots> parkingSlotsList=new ArrayList<>();
            for(int j=0;j<noOfParkingSlots;j++){
                ParkingSlots parkingSlots=new ParkingSlots(j, VehicleType.FOUR_WHEELERS, ParkingSlotStaus.VACANT,new ParkingFloors(i, null, ParkingFloorStatus.ACTIVE));
                parkingSlotsList.add(parkingSlots);
            }
            ParkingFloors parkingFloors=new ParkingFloors(i,parkingSlotsList,ParkingFloorStatus.ACTIVE);
            parkingFloorsList.add(parkingFloors);
        }

        //Creating Operators
        int noOfOperators=4;
        List<Operator>operatorList=new ArrayList<>();
        for(int k=0;k<noOfOperators;k++){
            Operator operator=new Operator(k,"x:"+k);
            operatorList.add(operator);
        }
        //Creating gates
        int noOfGates=4;
        List<Gate>gateList=new ArrayList<>();
        GateRepository gateRepository=new GateRepository();
        for(int x=0;x<noOfGates;x++){
            Gate gate=new Gate(x,GateStatus.ACTIVE,operatorList.get(x),GateType.ENTRY);
            gateRepository.save(x,gate);
            gateList.add(gate);
        }

        //Creating a different parking lots
        ParkingLot parkingLot=new ParkingLot(1,parkingFloorsList,ParkingLotStatus.ACTIVE,gateList);
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
        parkingLotRepository.save(parkingLot.getParkingLotNumber(),parkingLot);
        List<TicketRequest> ticketRequestList=new ArrayList<>();
        ticketRequestList.add(new TicketRequest(VehicleType.FOUR_WHEELERS,"PY01-BL-7701",1,1));
        ticketRequestList.add(new TicketRequest(VehicleType.FOUR_WHEELERS,"TN01-LP-6789",2,1));
        ticketRequestList.add(new TicketRequest(VehicleType.FOUR_WHEELERS,"HT05-NP-3566",2,1));
        ticketRequestList.add(new TicketRequest(VehicleType.FOUR_WHEELERS,"TL09-SD-6573",1,1));

        for(int t=0;t<ticketRequestList.size();t++) {
            TicketController ticketController = new TicketController();
            TicketResponse ticketResponse = ticketController.issueTicket(ticketRequestList.get(t));
            ticketResponse.getTicket().getParkingSlots().setParkingSlotStaus(ParkingSlotStaus.FILLED);
            System.out.println("Vehicle Entry Time:->" + ticketResponse.getTicket().getCurrentEntryTime());
            System.out.println("Entry Gate Number:->" + ticketResponse.getTicket().getGate().getGateNumber());
            System.out.println("Vehicle Number:->" + ticketResponse.getTicket().getVehicle().getVehicleNumber());
            System.out.println("Vehicle Type:->" + ticketResponse.getTicket().getVehicle().getVehicleType());
            System.out.println("Parking Floor:->" + ticketResponse.getTicket().getParkingFloors().getFloorNumber());
            System.out.println("Parking Slot Number:->" + ticketResponse.getTicket().getParkingSlots().getParkingSlotNumber());
            System.out.println("****************************************");
        }
    }
}
