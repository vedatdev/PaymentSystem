package com.vedatdemir.paymentsys.service.implemantation;

import com.vedatdemir.paymentsys.entity.Customer;
import com.vedatdemir.paymentsys.entity.Invoice;
import com.vedatdemir.paymentsys.entity.Payment;
import com.vedatdemir.paymentsys.enumaration.Status;
import com.vedatdemir.paymentsys.repo.PaymentRepository;
import com.vedatdemir.paymentsys.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final CustomerServiceImpl customerService;
    private final InvoiceServiceImpl invoiceService;

    @Override
    public Payment create(String subNo) {
        log.info("Making Payment");
        Payment payment = new Payment();
        List<Invoice> invoiceList = (List<Invoice>) invoiceService.getUnpaidInvoicesBySubNo(subNo);
        invoiceList.forEach(invoice -> invoice.setStatus(Status.PAID));
        invoiceList.forEach(invoice -> payment.setTotalAmount(payment.getTotalAmount().add(invoice.getAmount())));
        return paymentRepository.save(payment);
    }

    @Override
    public Collection<Payment> getAll() {
        log.info("Fetching all payments");
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(Long id) {
        log.info("Fetching payment by id : {}",id);
        return paymentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Payment Not Found"));
    }

    @Override
    public Payment update(Payment payment) {
        log.info("Payment updating : {}",payment.getSubscriberNo());
        return paymentRepository.save(payment);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting payment by ID : {}",id);
        paymentRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
