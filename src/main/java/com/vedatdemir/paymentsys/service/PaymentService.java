package com.vedatdemir.paymentsys.service;

import com.vedatdemir.paymentsys.entity.Payment;

import java.util.Collection;

public interface PaymentService {

    Payment create(String subNo);
    Collection<Payment> getAll();
    Payment getById(Long id);
    Payment update(Payment payment);
    Boolean delete(Long id);

}
