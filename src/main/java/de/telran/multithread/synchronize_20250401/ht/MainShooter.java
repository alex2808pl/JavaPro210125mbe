package de.telran.multithread.synchronize_20250401.ht;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

//1. На соревнованиях 5 спортсменов начинают одновременно стрелять в одну мишень.
//Если кто-нибудь в нее попадает(сделать Random-но), то мишень разрушается и другие в нее уже попасть не могут,
//но что-то пошло не так. Исправь программу, чтобы другие потоки "видели" изменения значения
//переменной isHit и больше его не меняли. Как только мишень разрушена кем то из стрелков,
//соревнования прекращаются. Подумайте, можно ли использовать класс AtomicBoolean?

public class MainShooter {
    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean isHit = new AtomicBoolean(false); //мишень
        Thread[] shooters = new Thread[5];
        for (int i = 0; i < 5; i++) {
            shooters[i] = new Thread(new Shooter(isHit), "Стрелок "+(i+1));
            //shooters[i] = new ShooterThread(isHit); //аналог
            shooters[i].start();
            Thread.sleep(100);
        }

        for (int i = 0; i < 5; i++) {
            shooters[i].join();
        }


    }
}

class Shooter implements Runnable {
    private AtomicBoolean isHit;

    public Shooter(AtomicBoolean isHit) {
        this.isHit = isHit;
    }

    @Override
    public void run() {
        Random random = new Random();

        if(!isHit.get()) {
            isHit.set(random.nextBoolean()); //выстрел
            System.out.println(Thread.currentThread().getName()+" его выстрел -> "+isHit.get());
        } else {
            System.out.println(Thread.currentThread().getName()+" не стреляет, т.к. мишень поражена");
        }
    }
}

class ShooterThread extends Thread {
    private AtomicBoolean isHit;

    public ShooterThread(AtomicBoolean isHit) {
        this.isHit = isHit;
    }

    @Override
    public void run() {
        Random random = new Random();

        if(!isHit.get()) {
            isHit.set(random.nextBoolean()); //выстрел
            System.out.println(Thread.currentThread().getName()+" его выстрел -> "+isHit.get());
        } else {
            System.out.println(Thread.currentThread().getName()+" не стреляет, т.к. мишень поражена");
        }
    }
}
