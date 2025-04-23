package de.telran.solid_20250423.d;

import java.math.BigDecimal;
//Dependency inversion principle – принцип инверсии зависимостей
//        (зависимости внутри системы строятся на основе абстракций. Модули верхнего уровня не зависят от модулей нижнего уровня.
//        Абстракции не должны зависеть от деталей. Детали должны зависеть от абстракций);


public class Shop {
    private Cash cash;
    public Shop(Cash cash) {
        this.cash = cash;
    }
    public void doPayment(Object order, BigDecimal amount){
        cash.doTransaction(amount);
    }
}
