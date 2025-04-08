package de.telran.multithread.synchronized_20250408.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // создание задачи
        Callable<Integer> task1 = new ThreadCallable(0, 1_000_000, 17);
        Callable<Integer> task2 = new ThreadCallable(1_000_001, 10_000_000, 17);
        Callable<Integer> task3 = new ThreadCallable(10_000_000, 100_000_000, 17);

        // создание переменной Future для возврата результата
        FutureTask<Integer> futureTask1 = new FutureTask<>(task1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(task2);
        FutureTask<Integer> futureTask3 = new FutureTask<>(task3);

        // запуск задач в отдельном потоке
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        new Thread(futureTask3).start();

        System.out.println("+ Общее количество чисел, которые деляться на 17 = "+(futureTask1.get()+futureTask2.get()+futureTask3.get()));

        // получение результата из потока
        int res1 = futureTask1.get();
        int res2 = futureTask2.get();
        int res3 = futureTask3.get();

        System.out.println("0...1_000_000 = "+res1);
        System.out.println("1_000_001...10_000_000 = "+res2);
        System.out.println("10_000_001...100_000_000 = "+res3);

        System.out.println("- Общее количество чисел, которые деляться на 17 = "+(res1+res2+res3));

    }
}
