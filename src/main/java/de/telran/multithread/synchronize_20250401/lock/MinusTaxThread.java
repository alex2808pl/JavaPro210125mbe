package de.telran.multithread.synchronize_20250401.lock;

import java.util.concurrent.locks.Lock;

public class MinusTaxThread extends Thread{
    private Account account;
    private int sum;
    private Lock lockTax;


    public MinusTaxThread(Account account, int sum, Lock lockTax) {
        this.account = account;
        this.sum = sum;
        this.lockTax = lockTax;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            lockTax.lock(); // для синхронизации работы с налоговым счетом
                account.minusSum(sum);
                // какие то другие команды
            lockTax.unlock();
         }

    }
}
