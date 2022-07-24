package com.vedatdemir.paymentsys.enumaration;

public enum Status {
    PAID("PAID"),
    UNPAID("UNPAID");

    private final String status;

    Status(String status){

        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
