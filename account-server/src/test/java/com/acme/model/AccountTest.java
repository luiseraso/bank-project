package com.acme.model;

import com.acme.model.exceptions.InsufficientBalanceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {

    @Test
    public void testDeposite() {
        Account account = new Account("client001", 50.0);
        account.deposite(20.0);
        assertEquals(70.0, account.getBalance());
    }

    @Test
    public void testWithdraw_withBalance() {
        Account account = new Account("client001", 50.0);
        account.withdraw(20.0);
        assertEquals(30.0, account.getBalance());
    }

    @Test
    public void testWithdraw_withoutBalance() {
        Account account = new Account("client001", 20.0);
        var exception = Assertions.assertThrows(InsufficientBalanceException.class, () ->
                account.withdraw(50.0));
        assertTrue(exception.getMessage().startsWith("Insufficient balance in account"));
    }
}
