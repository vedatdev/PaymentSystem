package com.vedatdemir.paymentsys.service.implemantation;

import com.vedatdemir.paymentsys.entity.Customer;
import com.vedatdemir.paymentsys.repo.CustomerRepository;
import com.vedatdemir.paymentsys.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        log.info("Saving new Customer : {}",customer.getSubscriberNo());
        return customerRepository.save(customer);
    }

    @Override
    public Collection<Customer> getAll() {
        log.info("Fetching all customers");
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Long id) {
        log.info("Fetching customer by id : {}",id);
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer Not Found"));
    }

    @Override
    public Customer update(Customer customer) {
        log.info("Customer updating : {}",customer.getSubscriberNo());
        return customerRepository.save(customer);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting customer by ID : {}",id);
        customerRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Customer getBySubNo(String subNo) {
        log.info("Fetching customer by subNo : {}",subNo);
        return customerRepository.getCustomerBySubscriberNo(subNo);
    }


}
