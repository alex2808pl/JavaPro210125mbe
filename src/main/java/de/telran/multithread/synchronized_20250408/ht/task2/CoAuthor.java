package de.telran.multithread.synchronized_20250408.ht.task2;

import java.util.concurrent.Phaser;

public class CoAuthor extends Thread{

    Phaser phaser;

    String name;

    public CoAuthor(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
    }

    @Override
    public void run() {
        phaser.register();
        System.out.println("Я - " + name + " - пишу дополнительные главы");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phaser.arriveAndDeregister();
    }
}
