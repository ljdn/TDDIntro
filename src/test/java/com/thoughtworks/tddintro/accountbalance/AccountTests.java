package com.thoughtworks.tddintro.accountbalance;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    Account myAccount = new Account(100);

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        myAccount.deposit(50);
        assertThat(myAccount.getBalance(), is(150));
    }
//
    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        myAccount.withdraw(50);
        assertThat(myAccount.getBalance(), is(50));
    }
//
//    @Test
//    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
//
//    }
}
