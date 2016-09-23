package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by No Password on 9/24/2016.
 */
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void deposit(int i) {
        balance += i;
    }

    public int getBalance() {
        return balance;
    }
}
