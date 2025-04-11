package de.telran.multithread.synchronized_20250408.ht.task2;

import java.util.concurrent.Phaser;

public class Pressmen extends Thread{
    Phaser phaser;

    String name;

    public Pressmen(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
    }

    @Override
    public void run() {
        phaser.register();
        System.out.println("Мы - " + name + " - печатаем книгу");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phaser.arriveAndDeregister();
    }
}
