package com.acme.model.exceptions;

import com.acme.model.Account;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(Account account) {
        super(String.format("Insufficient balance in account %s", account.getId()));
    }
}
