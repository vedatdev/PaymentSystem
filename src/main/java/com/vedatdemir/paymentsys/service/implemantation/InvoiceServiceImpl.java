package com.vedatdemir.paymentsys.service.implemantation;

import com.vedatdemir.paymentsys.entity.Customer;
import com.vedatdemir.paymentsys.entity.Invoice;
import com.vedatdemir.paymentsys.enumaration.Status;
import com.vedatdemir.paymentsys.repo.CustomerRepository;
import com.vedatdemir.paymentsys.repo.InvoiceRepository;
import com.vedatdemir.paymentsys.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

    private final CustomerServiceImpl customerService;
    private final InvoiceRepository invoiceRepository;

    @Override
    public Invoice create(Invoice invoice) {
        invoice.setProcessDate(new Date());
        Customer customer = customerService.getBySubNo(invoice.getSubscriberNo());
        customer.getInvoiceList().add(invoice);
        customerService.update(customer);
        return invoice;
    }

    @Override
    public Collection<Invoice> getAll() {
        log.info("Fetching all invoices");
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getById(Long id) {
        log.info("Fetching invoice by id : {}",id);
        return invoiceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Invoice Not Found"));
    }

    @Override
    public Invoice update(Invoice invoice) {
        log.info("Customer updating : {}",invoice.getSubscriberNo());
        return invoiceRepository.save(invoice);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting customer by ID : {}",id);
        invoiceRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Collection<Invoice> getUnpaidInvoicesBySubNo(String subNo) {
        log.info("Fetching invoices by subscriber number : {}",subNo);
        return invoiceRepository.getInvoicesBySubscriberNoAndStatus(subNo, Status.UNPAID);
    }
}
