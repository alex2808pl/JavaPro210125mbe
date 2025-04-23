package de.telran.solid_20250423.l;

import java.math.BigDecimal;
//Liskov substitution principle – принцип подстановки Барбары Лисков
//        (функции, которые используют базовый тип, должны иметь возможность
//        использовать подтипы базового типа, не зная об этом. Подклассы не
//        могут замещать поведения базовых классов. Подтипы должны дополнять базовые типы);

// L - не работает, потому что  в наследнике DepositAccount сломалась функциональность payment() предка Account
public class MainAccount {
    public static void main(String[] args) {
        Account account = new Account();
        System.out.println(account.balance("11111"));
        account.payment("1111",new BigDecimal(200));

        account = new SalaryAccount();
        account.payment("1111",new BigDecimal(200));

        account = new DepositAccount();
        account.payment("1111",new BigDecimal(200));

    }
}
