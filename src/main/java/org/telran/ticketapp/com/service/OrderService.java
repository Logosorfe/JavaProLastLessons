package org.telran.ticketapp.com.service;

import org.telran.ticketapp.com.entity.Order;

import java.util.List;

public interface OrderService {

    Order add (Long userId, Order order);

    List<Order> getAll();

    Order getById(Long orderId);
}
