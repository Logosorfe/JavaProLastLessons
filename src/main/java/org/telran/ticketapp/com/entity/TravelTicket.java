package org.telran.ticketapp.com.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // объекты этого класса это строки в таблице базы данных
@Table(name = "travel_tickets")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TravelTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private double price;

    private double priceByYear; // price_by_year

    @Column(name = "half_price")
    private double priceByHalfYear; // half_price
}
