package de.telran.generic_20250311;

import java.util.List;

public class MainAccount {
    public static void main(String[] args) {
        Account account = new Account(12345, 1000);
        System.out.println(account.getId());
        System.out.println("account = "+account.getSum());
        account.setSum(1200);
        System.out.println("account = "+account.getSum());

        //Account account1 = new Account("DE12345", 1000); //создать нельзя

        AccountObject accountObject1 = new AccountObject(12345, 2000);
        System.out.println("accountObject1 = " + accountObject1.getId());

        AccountObject accountObject2 = new AccountObject("DE12345", 2000);
        System.out.println("accountObject2 = "+accountObject2.getId());

        Integer sum = (Integer) accountObject1.getId() + 12; // успешно
        System.out.println("sum = "+sum);
        //sum = (Integer) accountObject2.getId() + 33; // нельзя, ошибка при выполнении


        AccountGeneric<Integer> accountGeneric1 = new AccountGeneric<Integer>(12345, 3000);
        System.out.println(accountGeneric1.getId());
        System.out.println("accountGeneric1 = "+accountGeneric1.getSum());
        accountGeneric1.setSum(3200);
        System.out.println("accountGeneric1 = "+accountGeneric1.getSum());

        // accountGeneric1 - id должно быть Integer
//        accountGeneric1 = new AccountGeneric<Integer>("DE12345", 3000);
//        AccountGeneric<Integer> accountGeneric2 = new AccountGeneric<Integer>("DE12345", 3000);

        AccountGeneric<String> accountGeneric3 = new AccountGeneric<>("DE12345", 3000);
        System.out.println("accountGeneric3 = "+accountGeneric3.getId());
        accountGeneric3.setSum(4321);
        System.out.println("accountGeneric3 = "+accountGeneric3.getSum());

        // accountGeneric1 = accountGeneric3; //нельзя

        AccountGeneric<Integer> accountGeneric4 = new AccountGeneric<>(67890, 8000);
        accountGeneric1 = accountGeneric4;

        AccountGeneric accountGeneric5; //грязные типы - НЕ РЕКОМЕНДУЕТСЯ
        accountGeneric5 = new AccountGeneric<>("DE12345", 12324);
        accountGeneric5 = new AccountGeneric<>(12345, 12324);


        AccountInterface<String> accountInterface = new AccountInterface<>("DE12345",9876);
        System.out.println("accountInterface = "+accountInterface.getId());
        accountInterface.setSum(4321);
        System.out.println("accountInterface = "+accountInterface.getId());

        AccountVisible<String> interfaceAcc = accountInterface; // сужение (только на просмотр)
        System.out.println("interfaceAcc = "+interfaceAcc.getId());
        //interfaceAcc.setSum(4321); // не возможно, потому что она не опубликована в интерфейсе

        // класс не generic - интерфейс generic
        AccountInteger accountInteger = new AccountInteger(12345, 4000);
        System.out.println("accountInteger = "+accountInteger.getId());

        // 2 и более generic параметров
        AccountTwoGeneric<String, Double> accountTwoGeneric1 = new AccountTwoGeneric<>("DE1234", 1000.0);
        System.out.println("accountTwoGeneric1 = "+accountTwoGeneric1.getId());
        accountTwoGeneric1.setSum(4321.5);
        System.out.println("accountTwoGeneric1 = "+accountTwoGeneric1.getSum());


        // реальные объекты, с чем встретитесь
        List<Integer> listInt = List.of(1,2,3,4,5,6);
        System.out.println("List<Integer> listInt = "+listInt);

    }
}
