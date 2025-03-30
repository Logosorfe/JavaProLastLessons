package org.telran.ticketapp.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.ticketapp.com.model.Ticket;
import org.telran.ticketapp.com.repository.TicketRepository;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository repository;

    @Override
    public List<Ticket> getAll() {
        return repository.getAll();
    }

    @Override
    public Ticket getById(String id) {
        return repository.getById(id);
    }

    @Override
    public Ticket create(Ticket ticket) {
        return repository.create(ticket);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }
}
