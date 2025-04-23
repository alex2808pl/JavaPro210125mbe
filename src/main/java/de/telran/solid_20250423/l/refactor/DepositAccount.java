package de.telran.solid_20250423.l.refactor;

import java.math.BigDecimal;

public class DepositAccount extends Account {
    @Override
    public BigDecimal balance(String numberAccount){
        //logic
        return new BigDecimal(333);
    };
    @Override
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }
}
