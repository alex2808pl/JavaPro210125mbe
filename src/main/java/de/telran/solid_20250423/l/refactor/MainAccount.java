package de.telran.solid_20250423.l.refactor;

import java.math.BigDecimal;

// L - работает, потому что  в наследнике DepositAccount нет  функциональности payment() предка Account
public class MainAccount {
    public static void main(String[] args) {
        Account account = new Account();
        System.out.println(account.balance("11111"));
        //account.payment("1111",new BigDecimal(200));

        account = new SalaryAccount();
        account.refill("1111",new BigDecimal(200));

        PaymentAccount accountPayment = new SalaryAccount();
        accountPayment.payment("1111",new BigDecimal(200));

        SalaryAccount salaryAccount = new SalaryAccount();

        account = new DepositAccount();
        account.refill("1111",new BigDecimal(200));
//        //account.payment("1111",new BigDecimal(200)); // не сможем вызвать
    }
}
