package de.telran.multithread.syncronizators_20250404.exchanger;

import java.util.concurrent.Exchanger;

public class MainDivCount {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        new Thread(new Thread1Interval(exchanger),"Поток 0..10_000").start();
        new Thread(new Thread2Interval(exchanger), "Поток 10_000..100_000").start();
    }
}

class Thread1Interval implements Runnable {
    Exchanger<Integer> exchanger;

    public Thread1Interval(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" начал работу.");
        int count = 0;
        for (int i = 0; i < 10_000; i++) {
                if(i % 17 == 0)
                    count++;
        }
        try {
            System.out.println(Thread.currentThread().getName()+" ожидает обмена. count="+count);
            int res = exchanger.exchange(count);
            System.out.println(Thread.currentThread().getName()+" получил при обмене -> "+res);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Thread2Interval implements Runnable {
    Exchanger<Integer> exchanger;

    public Thread2Interval(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" начал работу.");
        int count = 0;
        for (int i = 10_001; i < 100_000; i++) {
            if(i % 17 == 0)
                count++;
        }
        try {
            System.out.println(Thread.currentThread().getName()+" ожидает обмена. count="+count);
            int res = exchanger.exchange(count);
            System.out.println(Thread.currentThread().getName()+" получил при обмене -> "+res);
            System.out.println(Thread.currentThread().getName()+" общая сумма после обмена -> "+(res+count));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
