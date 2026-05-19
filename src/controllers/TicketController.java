package controllers;

import dtos.requests.IssueTicketRequestDto;
import dtos.responses.IssueTicketResponseDto;
import dtos.responses.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto createTicket(IssueTicketRequestDto requestDto){
        IssueTicketResponseDto responseDto = new IssueTicketResponseDto();
        try{
            Ticket ticket = ticketService.createTicket(
                    requestDto.getParkingLotId(),
                    requestDto.getGateId(),
                    requestDto.getNumberPlate(),
                    requestDto.getVehicleType(),
                    requestDto.getDriverPhoneNumber(),
                    requestDto.getDriverName()
            );
            responseDto.setTicketId(ticket.getId());
            responseDto.setParkingSpotNumber(ticket.getAssignedParkingSpot().getSpotNo());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setFailureMessage(e.getMessage());
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
