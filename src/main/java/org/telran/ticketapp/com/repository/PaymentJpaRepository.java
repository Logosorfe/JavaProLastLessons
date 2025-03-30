package org.telran.ticketapp.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telran.ticketapp.com.entity.Payment;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {
}
