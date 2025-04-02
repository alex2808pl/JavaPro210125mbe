package de.telran.multithread.synchronize_20250401.deadlock;

public class MainDeadlockPaperScissors  implements Runnable{
    private static class Resource {
    }

    private final Resource scissors = new Resource();
    private final Resource paper = new Resource();

    public void doSun() {
        synchronized (scissors) { // May deadlock here
            System.out.println(Thread.currentThread().getName()
                    + " взяла ножницы для вырезания солнышка");
            synchronized (paper) {
                System.out.println(Thread.currentThread().getName()
                        + " взяла бумагу для вырезания солнышка");
                System.out.println(Thread.currentThread().getName()
                        + " вырезает солнышко");
            }
        }
    }

    public void doCloudWithoutDeadLock() {
        synchronized (scissors) { // May deadlock here
            System.out.println(Thread.currentThread().getName()
                    + " взяла ножницы для вырезания облачка");
            synchronized (paper) {
                System.out.println(Thread.currentThread().getName()
                        + " взяла бумагу для вырезания облачка");
                System.out.println(Thread.currentThread().getName()
                        + " вырезает облачко");
            }
        }
    }

    public void doCloudWithDeadLock() {
        synchronized (paper) { // May deadlock here
            System.out.println(Thread.currentThread().getName()
                    + " взяла бумагу для вырезания облачка");
            synchronized (scissors) {
                System.out.println(Thread.currentThread().getName()
                        + " взяла ножницы для вырезания облачка");
                System.out.println(Thread.currentThread().getName()
                        + " вырезает облачко");
            }
        }
    }

    @Override
    public void run() {
        doSun();
        //doCloudWithDeadLock();
        doCloudWithoutDeadLock();
    }

    public static void main(String[] args) {
        MainDeadlockPaperScissors job = new MainDeadlockPaperScissors();
        Thread masha = new Thread(job, "Маша");
        Thread dasha = new Thread(job, "Даша");
        masha.start();
        dasha.start();

    }

    private void sleeps(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}


