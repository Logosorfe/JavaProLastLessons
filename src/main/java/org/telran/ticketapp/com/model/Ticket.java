package org.telran.ticketapp.com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {

    private String id;

    private String name;

    private double price;

    public Ticket() {
        //
    }


    public Ticket(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Ticket(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
