package de.telran.solid_20250423.d.refactor;

import java.math.BigDecimal;

public class PayByPhone implements Payments {
    @Override
    public void doTransaction(BigDecimal amount) {
        //logic
        System.out.println("Плачу телефоном = "+amount);
    }
}
