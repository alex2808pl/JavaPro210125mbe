package de.telran.solid_20250423.l;

import java.math.BigDecimal;

public class DepositAccount extends Account{
    @Override
    public BigDecimal balance(String numberAccount){
        // new logic
        return new BigDecimal(333);
    };

    @Override
    public void refill(String numberAccount, BigDecimal sum){
        // new logic
    }

    @Override
    public void payment(String numberAccount, BigDecimal sum){ // приходиться отказываться от этого метода
        throw new UnsupportedOperationException("Operation not supported");
    }
}
