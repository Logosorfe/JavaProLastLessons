package org.telran.ticketapp.com.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telran.ticketapp.com.entity.Order;
import org.telran.ticketapp.com.entity.Payment;
import org.telran.ticketapp.com.model.OrderState;
import org.telran.ticketapp.com.repository.PaymentJpaRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentJpaRepository repository;
    private final OrderService orderService;

    @Override
    public void makePayment(Long orderId) {
        Order order = orderService.getById(orderId);
        order.setState(OrderState.PAID);
        Payment payment = Payment.builder()
                .paymentDate(new Date())
                .order(order)
                .build();
        repository.save(payment);
    }
}
