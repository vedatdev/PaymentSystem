package com.vedatdemir.paymentsys.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be space chars")
    @Pattern(regexp = "^[a-zA-Z\\s]+",message = "Name is not proper name")
    private String name;
    @NotNull(message = "Surname cannot be empty")
    @NotBlank(message = "Surname cannot be space chars")
    @Pattern(regexp = "^[a-zA-Z\\s]+",message = "Surname is not proper name")
    private String surname;
    @Column(unique = true)
    @NotNull(message = "SubscriberNo cannot be empty")
    @Pattern(message = "Subscriber no must contains only digits", regexp = "^\\d+")
    private String subscriberNo;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ownerId",referencedColumnName = "id")
    private List<Payment> paymentList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private List<Invoice> invoiceList = new ArrayList<>();

    public Customer(String name, String surname, String subscriberNo, List<Payment> paymentList, List<Invoice> invoiceList) {
        this.name = name;
        this.surname = surname;
        this.subscriberNo = subscriberNo;
        this.paymentList = paymentList;
        this.invoiceList = invoiceList;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSubscriberNo() {
        return subscriberNo;
    }

    public void setSubscriberNo(String subscriberNo) {
        this.subscriberNo = subscriberNo;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
