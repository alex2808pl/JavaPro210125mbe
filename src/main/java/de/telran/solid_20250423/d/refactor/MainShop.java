package de.telran.solid_20250423.d.refactor;

import java.math.BigDecimal;

public class MainShop {
    public static void main(String[] args) {
        Shop shop = new Shop(new Cash());
        shop.doPayment("1111", new BigDecimal(1000));

        Shop shop2 = new Shop(new BankCard());
        shop2.doPayment("1111", new BigDecimal(1000));
    }
}
