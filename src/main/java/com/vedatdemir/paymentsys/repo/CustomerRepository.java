package com.vedatdemir.paymentsys.repo;

import com.vedatdemir.paymentsys.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer getCustomerBySubscriberNo(String subscriberNo);

    Collection<Customer> getCustomersByName(String name);
}
