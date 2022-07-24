package com.vedatdemir.paymentsys;

import com.vedatdemir.paymentsys.entity.Customer;
import com.vedatdemir.paymentsys.entity.Invoice;
import com.vedatdemir.paymentsys.enumaration.Status;
import com.vedatdemir.paymentsys.service.implemantation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PaymentsysApplication {

	private final CustomerServiceImpl customerService;

	@Autowired
	public PaymentsysApplication(CustomerServiceImpl customerService) {

		this.customerService = customerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentsysApplication.class, args);
	}

	@Bean
	@Transactional
	public void addCustomer(){

		Customer customer = customerService.getById(9L);
		Invoice invoice = new Invoice("12",new BigDecimal(444), new Date(), Status.PAID);
		customer.getInvoiceList().add(invoice);
		customerService.update(customer);

	}
}
