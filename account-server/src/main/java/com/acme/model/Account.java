package com.acme.model;

import com.acme.model.exceptions.InsufficientBalanceException;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Account {

    private static final Logger logger = LoggerFactory.getLogger(Account.class);

    private final UUID id;
    private final String client;
    private double balance;

    public Account(String client, double balance) {
        this.id = UUID.randomUUID();
        this.client = client;
        this.balance = balance;
    }

    public void deposite(double value) {
        logger.info("Deposite: account={}, value={}", id, value);
        this.balance += value;
    }

    public void withdraw(double value) {
        logger.info("Withdraw: account={}, value={}" , id, value);
        if(value > balance) {
            throw new InsufficientBalanceException(this);
        }
        balance -= value;
    }

    public void accountInformation() {
        logger.info("Account Information: account={}, client={}, balance={}", id, client, balance);
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
