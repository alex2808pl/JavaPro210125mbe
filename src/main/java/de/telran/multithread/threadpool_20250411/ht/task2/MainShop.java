package de.telran.multithread.threadpool_20250411.ht.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*2*. В одном из предыдущий ДЗ у вас была задача:
У вас в магазине распродажа. К вам набежало 10 000 клиентов и вы пытаетесь корректно всех обслужить с
        учетом того, что одновременно у вас внутри магазина может находиться не более 10 покупателей(согласно
Сымитируйте данный процесс работы и подсчитайте за какой период времени вы сможете обслужить данный
объем покупателей?
Отдельный покупатель - отдельный поток.
Можно было бы реализовать данную задачу не используя семафор?*/
public class MainShop {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10); //будет сразу создано и ограничен МАX количество,
        for (int i = 0; i < 1_000; i++) {
            //new Buyer(i+1, 10).start();
            executor.execute(new Buyer(i+1, 100));
        }
        //executor.awaitTermination(10, TimeUnit.SECONDS); // ждем завершения
        executor.shutdown();
    }
}
