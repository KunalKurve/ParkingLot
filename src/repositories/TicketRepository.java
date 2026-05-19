package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {

    private final Map<Integer, Ticket> savedTickets;
    private static int countId = 0;

    public TicketRepository(){
        this.savedTickets = new HashMap<>();
    }

    public Optional<Ticket> findById(int ticketId){
        if(savedTickets.containsKey(ticketId)){
            return Optional.of(savedTickets.get(ticketId));
        }
        return Optional.empty();
    }

    public Ticket save(Ticket ticket){
        if(ticket.getId() == 0){
            ticket.setId(++countId);
        }
        savedTickets.put(ticket.getId(), ticket);
        return ticket;
    }
}
