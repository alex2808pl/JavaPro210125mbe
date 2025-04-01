package de.telran.multithread.synchronize_20250401.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainLock {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        Account accountTax = new Account();

        Lock lock = new ReentrantLock();
        Lock lockTax = new ReentrantLock();

        Thread father = new PlusThread(account, 10, lock, accountTax, lockTax);
        Thread child = new MinusThread(account, 10, lock);
        Thread tax = new MinusTaxThread(accountTax, 1,  lockTax); // отправляем в налоговую

        System.out.println("До = "+account.getSum());

        father.start(); // + 1 млн.
        child.start(); // - 1 млн.
        tax.start();

        father.join();
        child.join();
        tax.join();

        System.out.println("После = "+account.getSum());

        System.out.println("После Tax = "+accountTax.getSum());
    }
}
