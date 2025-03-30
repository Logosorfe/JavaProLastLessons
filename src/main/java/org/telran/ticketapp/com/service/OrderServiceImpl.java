package org.telran.ticketapp.com.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telran.ticketapp.com.entity.Order;
import org.telran.ticketapp.com.entity.User;
import org.telran.ticketapp.com.model.OrderState;
import org.telran.ticketapp.com.repository.OrderJpaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderJpaRepository orderJpaRepository;
    private final UserService userService;

//    public OrderServiceImpl(OrderJpaRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public Order add(Long userId, Order order) {
        User user = userService.findById(userId);
        order.setUser(user);
        order.setState(OrderState.UNPAID);
        return orderJpaRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderJpaRepository.findAll();
    }

    @Override
    public Order getById(Long orderId) {
        return orderJpaRepository.findById(orderId).get();
    }
}
