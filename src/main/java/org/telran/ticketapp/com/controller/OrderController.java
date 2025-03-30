package org.telran.ticketapp.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.telran.ticketapp.com.entity.Order;
import org.telran.ticketapp.com.service.OrderService;


import java.util.List;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order add(@RequestParam Long userId, @RequestBody Order order) {
        return orderService.add(userId, order);
    }

    @GetMapping
    public List<Order> list() {
        return orderService.getAll();
    }
}
