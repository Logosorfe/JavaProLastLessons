package org.telran.ticketapp.com.service;

import org.telran.ticketapp.com.entity.TravelTicket;

import java.util.List;

public interface TravelTicketService {

    List<TravelTicket> getAll();

    TravelTicket getById(Long id);

    TravelTicket create(TravelTicket ticket);

    void delete(Long id);

    TravelTicket getByTitle(String title);

    TravelTicket getCheapest();
}
