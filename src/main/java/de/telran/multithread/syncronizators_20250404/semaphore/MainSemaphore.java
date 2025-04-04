package de.telran.multithread.syncronizators_20250404.semaphore;

import java.util.concurrent.Semaphore;

public class MainSemaphore {
    public static void main(String[] args) throws InterruptedException {
        // Ограничить количество одновременно проезжающих автомобилей по участку ремонта шоссе
        Semaphore semaphore = new Semaphore(3); //fair - не всегда срабатывает, не рекомендуется использовать
        for (int i = 0; i < 10; i++) {
            new Thread(new Auto(semaphore), "Поток - "+i).start();
            Thread.sleep(200);
        }
    }
}

class Auto implements Runnable
{
    Semaphore semaphore;
    public Auto(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    public void run() {
        try {
            semaphore.acquire(); // -1
            System.out.println(Thread.currentThread().getName()+" заехал в зону ограничения "+System.currentTimeMillis());
            Thread.sleep(2000);
            semaphore.release(); // +1
            System.out.println(Thread.currentThread().getName()+" выехал из зоны ограничения");
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
