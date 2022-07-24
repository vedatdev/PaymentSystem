package com.vedatdemir.paymentsys.repo;

import com.vedatdemir.paymentsys.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
