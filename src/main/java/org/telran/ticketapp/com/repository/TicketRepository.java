package org.telran.ticketapp.com.repository;

import org.telran.ticketapp.com.model.Ticket;

import java.util.List;

public interface TicketRepository {

    List<Ticket> getAll();

    Ticket getById(String id);

    Ticket create(Ticket ticket);

    void delete(String id);
}
