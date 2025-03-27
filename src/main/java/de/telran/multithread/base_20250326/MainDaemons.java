package de.telran.multithread.base_20250326;

public class MainDaemons {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(" ==== НАЧАЛО РАБОТЫ  ===");

        long currentTime = System.currentTimeMillis();
        ThreadTask task1 = new ThreadTask(0, 500_000_000, 13, true);
        ThreadTask task2 = new ThreadTask(500_000_001, 1_000_000_000, 13, true);
        task1.setDaemon(true); // при завершении главного потока этот дочерний поток закрывается
        task2.setDaemon(true);
        task1.start();
        task2.start();

        Thread.sleep(1000); // приостанавливаю главный поток на 1 сек.
        System.out.println(" ==== КОНЕЦ РАБОТЫ ГЛАВНОГО ПОТОКА ===");

    }
}
