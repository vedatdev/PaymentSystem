package com.vedatdemir.paymentsys.entity;

import com.vedatdemir.paymentsys.enumaration.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "SubscriberNo cannot be empty")
    @Pattern(regexp = "^\\d+",message = "SubscriberNo must contains only digits")
    private String subscriberNo;
    private BigDecimal amount;
    private Date processDate;
    private Status status = Status.UNPAID; // default value is unpaid

    public Invoice(String subscriberNo, BigDecimal amount, Date processDate) {
        this.subscriberNo = subscriberNo;
        this.amount = amount;
        this.processDate = processDate;
    }

    public Invoice() {
    }

    public Invoice(String subscriberNo, BigDecimal amount, Date processDate, Status status) {
        this.subscriberNo = subscriberNo;
        this.amount = amount;
        this.processDate = processDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubscriberNo() {
        return subscriberNo;
    }

    public void setSubscriberNo(String subscriberNo) {
        this.subscriberNo = subscriberNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
