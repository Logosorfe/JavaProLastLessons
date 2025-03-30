package org.telran.ticketapp.com.repository;

import jakarta.annotation.PostConstruct;
import org.telran.ticketapp.com.model.Ticket;

import java.util.*;

//@Repository
public class InMemoryTicketRepositoryImpl implements TicketRepository {

    private Map<String, Ticket> storage = new HashMap<>();

    @PostConstruct
    private void init() {
        Ticket ticketOne = new Ticket(UUID.randomUUID().toString(), "TicketOne", 535);
        Ticket ticketTwo = new Ticket(UUID.randomUUID().toString(), "TicketTwo", 234);
        storage.put(ticketOne.getId(), ticketOne);
        storage.put(ticketTwo.getId(), ticketTwo);
    }

    @Override
    public List<Ticket> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Ticket getById(String id) {
        return storage.get(id);
    }

    @Override
    public Ticket create(Ticket ticket) {
        Ticket createdTicket = new Ticket(ticket.getName(), ticket.getPrice());
        createdTicket.setId(UUID.randomUUID().toString());
        storage.put(createdTicket.getId(), createdTicket);
        return createdTicket;
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }
}
