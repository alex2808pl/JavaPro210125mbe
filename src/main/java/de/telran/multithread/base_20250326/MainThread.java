package de.telran.multithread.base_20250326;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Integer.MAX_VALUE);
        // Без многопоточности
        //getCountDiv(0, Integer.MAX_VALUE, 13);
        getCountDiv(0, 1_000_000_000, 13);
        System.out.println(" ==== ================== ===");

        // Многопоточно (Thread)

        long currentTime = System.currentTimeMillis();
        ThreadTask task1 = new ThreadTask(0, 500_000_000, 13);
        ThreadTask task2 = new ThreadTask(500_000_001, 1_000_000_000, 13);
        task1.start();
        task2.start();
        // заставляем главный поток ждать завершения дочерних
        task1.join();
        task2.join();
        System.out.println("Общее количество (multi) = "+(task1.count+task2.count));
        System.out.println("Общее время выполнения (Thread) = "+(System.currentTimeMillis()-currentTime));
        System.out.println(" ==== ================== ===");

        // Используем также главный поток для работы
        currentTime = System.currentTimeMillis();
        ThreadTask task3 = new ThreadTask(0, 500_000_000, 13);
        task3.start();
        getCountDiv(500_000_001, 1_000_000_000, 13);
        task3.join(); //ожидаем завершение дочернего потока
        System.out.println("Общее количество (multi) = "+(task1.count+task2.count));
        System.out.println("Общее время выполнения (Thread) = "+(System.currentTimeMillis()-currentTime));

        // Runnable (альтернативное создание потока)
        System.out.println(" ==== Runnable ===");
        currentTime = System.currentTimeMillis();
        // создаем задачу, которую нужно выполнить в отдельном потоке
        RunnableTask runTask1 = new RunnableTask(0, 500_000_000, 13);
        RunnableTask runTask2 = new RunnableTask(500_000_001, 1_000_000_000, 13);
        // создаем поток и передаем в него задачу
        Thread th1 = new Thread(runTask1, "Task1"); //создаем поток с именем
        Thread th2 = new Thread(runTask2, "Task2");
        th1.start();
        th2.start();
        // заставляем главный поток ждать завершения дочерних
        th1.join();
        th2.join();
        System.out.println("Общее количество (multi) = "+(task1.count+task2.count));
        System.out.println("Общее время выполнения (Thread) = "+(System.currentTimeMillis()-currentTime));
        System.out.println(" ==== ================== ===");

        // НЕЛЬЗЯ использользовать в новых программах
        //th1.stop(); //останавливает дочерний поток, но не корректно!!!
        //th1.suspend(); // приостанавливает выполнение дочернего потока!!!
        //th1.resume(); // запускает ранее приостановленный suspend() дочерний поток !!!

        System.out.println(" ==== КОНЕЦ РАБОТЫ ГЛАВНОГО ПОТОКА ===");

    }


    private static void getCountDiv(int start, int end, int div) {
        long currentTime = System.currentTimeMillis(); // начальное значение времени

        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % div == 0) {
                count++;
            }
        }
        System.out.println("Количество = " + count);
        System.out.println("Время выполнения = " + (System.currentTimeMillis() - currentTime));
    }
}
