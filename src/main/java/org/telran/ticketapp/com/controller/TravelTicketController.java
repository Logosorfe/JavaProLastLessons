package org.telran.ticketapp.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.ticketapp.com.entity.TravelTicket;
import org.telran.ticketapp.com.service.TravelTicketService;

import java.util.List;

@RestController
@RequestMapping("travel_tickets")
//@Slf4j
public class TravelTicketController {

    private static final Logger log = LoggerFactory.getLogger(TravelTicketController.class);

    @Autowired
    private TravelTicketService service;

    @GetMapping
    public List<TravelTicket> getAll() {
        return service.getAll();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity getById(@PathVariable Long id) {
//        try {
//            TravelTicket travelTicket = service.getById(id);

    /// /            return ResponseEntity.ok(travelTicket);
//            return ResponseEntity.status(HttpStatus.OK).body(travelTicket);
//        } catch (TravelTicketNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//    }

    @GetMapping("/{id}")
    public TravelTicket getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public TravelTicket create(@RequestBody TravelTicket travelTicket) {
        return service.create(travelTicket);
    }

    @GetMapping("/search")
    public TravelTicket getByTitle(@RequestParam String title) {
//        log.info("Call method get by title {}", title);
        log.debug("Call method get by title {}", title);
        return service.getByTitle(title);
    }

    @GetMapping("/cheapest")
    public TravelTicket getCheapest() {
        return service.getCheapest();
    }
}
