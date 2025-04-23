package de.telran.solid_20250423.l;

import java.math.BigDecimal;

public class Account {
    // остаток по счету
    public BigDecimal balance(String numberAccount){
        //logic
        BigDecimal bigDecimal = new BigDecimal(1000);
        return bigDecimal;
    };

    // пополнение счета
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }

    // оплата со счета (cнятие денег)
    public void payment(String numberAccount, BigDecimal sum){
        //logic
        System.out.println("Оплачиваем со счета "+numberAccount+" сумму "+sum);
    }
}
