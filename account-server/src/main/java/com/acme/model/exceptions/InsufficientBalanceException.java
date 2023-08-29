package com.acme.model.exceptions;

import com.acme.model.Account;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(Account account) {
        super(String.format("Insufficient balance for user %s - %s - %f",
                account.getId(), account.getClient(), account.getBalance()));
    }
}
