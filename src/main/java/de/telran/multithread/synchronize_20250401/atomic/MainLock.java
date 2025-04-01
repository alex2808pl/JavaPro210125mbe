package de.telran.multithread.synchronize_20250401.atomic;

import de.telran.generic_20250311.AccountInteger;
import de.telran.multithread.synchronize_20250401.sync.inner.Account;

import java.util.concurrent.atomic.AtomicInteger;

public class MainLock {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger account = new AtomicInteger();
        AtomicInteger counter = new AtomicInteger(); // количество операций со счеом

        Thread father = new PlusThread(account, 10, counter);
        Thread child = new MinusThread(account, 10, counter);

        System.out.println("До = "+account.get());

        father.start(); // + 1 млн.
        child.start(); // - 1 млн.

        father.join();
        child.join();

        System.out.println("После = "+account.get());
        System.out.println("Кол-вщ операций = "+counter.get());
    }
}
