package Controllers;

import Dtos.ResponseStatus;
import Dtos.TicketRequest;
import Dtos.TicketResponse;
import Exceptions.InvalidGateNumberException;
import Exceptions.ParkingLotNotAvailableException;
import Exceptions.ParkingSlotFullException;
import Models.Ticket;
import Services.TicketService;

public class TicketController {
    public TicketService ticketService;
    public String SUCCESS_MESSAGE="Ticket generated successfully";
    public String Invalid_Gate="Invalid Gate";
    public String Invalid_Parking_Lot="Invalid Parking Lot";
    public String  ParkingSlotsFull="Invalid Parking Lot"
    public TicketResponse issueTicket(TicketRequest ticketRequest) {
        Ticket ticket=null;
        try {
            ticket=ticketService.issueTicket(ticketRequest);
        } catch (InvalidGateNumberException e) {
            return new TicketResponse(null, ResponseStatus.FAILURE,Invalid_Gate);
        } catch (ParkingLotNotAvailableException e) {
            return new TicketResponse(null, ResponseStatus.FAILURE,Invalid_Parking_Lot);
        } catch (ParkingSlotFullException e) {
            return new TicketResponse(null, ResponseStatus.FAILURE,ParkingSlotsFull);
        }
        return new TicketResponse(ticket, ResponseStatus.SUCCESS,SUCCESS_MESSAGE);

    }
}
