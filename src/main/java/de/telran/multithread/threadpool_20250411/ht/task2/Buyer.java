package de.telran.multithread.threadpool_20250411.ht.task2;

public class Buyer extends Thread{
    int number;
    long timeService;

    public Buyer(int number, long timeService) {
        this.number = number;
        this.timeService = timeService;

    }

    @Override
    public void run() {
        System.out.println("+ Покупатель №" + number + " заходит в магазин на потоке " + Thread.currentThread().getName());
        try {
            Thread.sleep(timeService); // иммитируем время обслуживание
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("- Покупатель №" + number + " выходит с магазина на потоке " + Thread.currentThread().getName());
    }
}
