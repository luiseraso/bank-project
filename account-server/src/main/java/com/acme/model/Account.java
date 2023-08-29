package com.acme.model;

import com.acme.model.exceptions.InsufficientBalanceException;

import java.util.UUID;

public class Account {

    private final UUID id;
    private final String client;
    private double balance;

    public Account(String client, double balance) {
        this.id = UUID.randomUUID();
        this.client = client;
        this.balance = balance;
    }

    public void deposite(double value) {
        this.balance += value;
    }

    public void withdraw(double value) {
        if(value > balance) {
            throw new InsufficientBalanceException(this);
        }
        balance -= value;
    }

    public UUID getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public double getBalance() {
        return balance;
    }
}
