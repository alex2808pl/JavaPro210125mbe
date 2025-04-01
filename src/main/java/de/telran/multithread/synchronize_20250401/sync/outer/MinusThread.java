package de.telran.multithread.synchronize_20250401.sync.outer;

public class MinusThread extends Thread{
    private Account account;
    private int sum;

    public MinusThread(Account account, int sum) {
        this.account = account;
        this.sum = sum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {

            synchronized (account) { //синхронизировать доступ к объекту account, используя его монитор (внешняя синхронизаця)
                account.minusSum(sum);
                // какие то другие команды
            }

        }

    }
}
