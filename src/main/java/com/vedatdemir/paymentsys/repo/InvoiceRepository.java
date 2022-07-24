package com.vedatdemir.paymentsys.repo;

import com.vedatdemir.paymentsys.entity.Invoice;
import com.vedatdemir.paymentsys.enumaration.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Collection<Invoice> getInvoicesBySubscriberNoAndStatus(String subNo, Status status);

}
