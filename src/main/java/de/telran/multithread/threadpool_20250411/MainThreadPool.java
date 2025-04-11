package de.telran.multithread.threadpool_20250411;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThreadPool {
    public static void main(String[] args) throws InterruptedException {
        //ExecutorService executor = Executors.newFixedThreadPool(5); //будет сразу создано и ограничен МАX количество,
        //ExecutorService executor = Executors.newSingleThreadExecutor(); //всегда только один поток
        // ExecutorService executor = Executors.newCachedThreadPool(); //использует освободившиеся потоки, нет ограничения
        ExecutorService executor = Executors.newWorkStealingPool(5); //использует указанное количество ядер, 1 - одно ядро

        for (int i = 0; i < 30; i++) {
            executor.execute(new Task(i+1));
            Thread.sleep(500);
        }

        Thread.sleep(2000);
        executor.shutdown();
    }
}

class Task implements Runnable {
    int taskNumber;

    public Task(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000); // иммитируем работу
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Обработан запрос пользователя №" + taskNumber + " на потоке " + Thread.currentThread().getName());
    }
}
