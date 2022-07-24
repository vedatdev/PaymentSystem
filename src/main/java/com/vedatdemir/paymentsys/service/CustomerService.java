package com.vedatdemir.paymentsys.service;

import com.vedatdemir.paymentsys.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


public interface CustomerService{

    Customer create(Customer customer);

    Collection<Customer> getAll();

    Customer getById(Long id);

    Customer update(Customer customer);

    Boolean delete(Long id);

    Customer getBySubNo(String subNo);

}
