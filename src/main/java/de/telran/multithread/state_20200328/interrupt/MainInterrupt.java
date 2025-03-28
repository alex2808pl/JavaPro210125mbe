package de.telran.multithread.state_20200328.interrupt;

public class MainInterrupt {
    public static void main(String[] args) throws InterruptedException {
        TaskRun task1 = new TaskRun(); //задача
        Thread th1 = new Thread(task1); // дочерний поток для задачи

        th1.start();
        Thread.sleep(1111); //приостанавливаю главный поток
        System.out.println("---"+th1.getState());
        th1.interrupt(); //уведомление дочернего потока, что ему нужно прервать свою работу

        System.out.println("Конец главного потока");
    }
}
