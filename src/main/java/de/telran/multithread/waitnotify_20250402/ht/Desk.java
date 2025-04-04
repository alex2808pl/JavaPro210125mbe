package de.telran.multithread.waitnotify_20250402.ht;

public class Desk {

    private int boxes=0;

    public synchronized void get() throws InterruptedException {  // забираем
        while (boxes==0) {
            wait();
        }
        boxes--;
        System.out.println(Thread.currentThread().getName()+" - робот взял коробку со стола");
        notify();
    }

    public synchronized void put() throws InterruptedException { // кладем
        while (boxes>=1) {
             wait();
        }
        boxes++;
        System.out.println(Thread.currentThread().getName()+" - робот кладет коробку со стола");
        notify();
    }
}
