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
        System.out.printf("Deposite: %f in account %s\n" , value, id);
        this.balance += value;
    }

    public void withdraw(double value) {
        System.out.printf("Withdraw: %f in account %s\n" , value, id);
        if(value > balance) {
            throw new InsufficientBalanceException(this);
        }
        balance -= value;
    }

    public void accountInformation() {
        System.out.printf("Account Information: id= %s, client= %s, balance= %f\n", id, client, balance);
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
