package de.telran.multithread.synchronize_20250401.sync.outer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainLock {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        Thread father = new PlusThread(account, 10);
        Thread child = new MinusThread(account, 10);

        System.out.println("До = "+account.getSum());

        father.start(); // + 1 млн.
        child.start(); // - 1 млн.

        father.join();
        child.join();

        System.out.println("После = "+account.getSum());
    }
}
