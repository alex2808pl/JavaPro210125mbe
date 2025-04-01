package de.telran.multithread.synchronize_20250401.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class PlusThread extends Thread{
    private AtomicInteger account;
    private int sum;
    private AtomicInteger counter;


    public PlusThread(AtomicInteger account, int sum,  AtomicInteger counter)
    {
        this.account = account;
        this.sum = sum;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
                account.addAndGet(sum);

                counter.incrementAndGet(); // учитываю эту операцию в счетчике
        }
    }
}
