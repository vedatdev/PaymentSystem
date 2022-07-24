package com.vedatdemir.paymentsys.service;

import com.vedatdemir.paymentsys.entity.Invoice;

import java.util.Collection;

public interface InvoiceService {

    Invoice create(Invoice invoice);
    Collection<Invoice> getAll();
    Invoice getById(Long id);
    Invoice update(Invoice invoice);
    Boolean delete(Long id);
    Collection<Invoice> getUnpaidInvoicesBySubNo(String subNo);

}
