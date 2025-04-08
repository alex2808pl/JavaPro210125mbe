package de.telran.multithread.synchronized_20250408.phaser;

import java.util.concurrent.Phaser;

public class MainPhaser {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(1); // 1 - главный поток тоже нужно включить в фазер
//                phaser.register(); // главный поток не регистрируем, потому что мы его зарегистрировали при создании Phaser

        int curPhase;
        System.out.println("Стартуем потоки");

        new Thread(new MyThread(phaser, "A")).start(); //parties+=1
        new Thread(new MyThread(phaser, "B")).start();//parties+=1
        new Thread(new MyThread(phaser, "C")).start();//parties+=1

        System.out.println("Главный поток запустился в первой фазе");
        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance(); // главный поток ожидает
        System.out.println("Phase " + (curPhase+1) + " окончена");

        // Работа главного потока во второй фазе
        new Thread(new MyThreadWithEnd(phaser, "D")).start();//parties+=1

        System.out.println("Главный поток запустился в второй фазе");
        curPhase = phaser.getPhase();
        // ожидаем завершения всеми потоками второй фазы
        phaser.arriveAndAwaitAdvance();   // 2 фаза
        System.out.println("Phase " + (curPhase+1) + " окончена");

        // Работа главного потока во третьей фазе
        Thread.sleep(1000);
        System.out.println("Главный поток запустился в третьей фазе");
        curPhase = phaser.getPhase();
        // снимаем основной поток исполнения с регистрации
        phaser.arriveAndDeregister();
        System.out.println("Phase " + (curPhase+1) + " окончена");


        if (phaser.isTerminated()) //работает ли фазер
            System.out.println("Phaser окончил работу");

        System.out.println(" == ГЛАВНЫЙ ПОТОК ОКОНЧЕН ==");
    }
}

class MyThread implements Runnable {
    Phaser phaser;
    String name;

    public MyThread(Phaser phaser, String name) {

        this.phaser = phaser;
        this.name = name;

        phaser.register(); //parties+=1 поток регистрируется в фазере
    }

    @Override
    public void run() {
        System.out.println("Поток " + name + " запустился в первой фазе");
        // Работа для первой фазы
        phaser.arriveAndAwaitAdvance(); // ожидаем завершения первой фазы

        // небольшая пауза, чтобы не нарушать порядок вывода. Только для демонстрации, в реальности этого может не быть
        // Работа для второй фазы
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Поток " + name + " запустился в второй фазе");
        // ожидаем завершения всеми потоками второй фазы
        phaser.arriveAndAwaitAdvance(); //2 фаза

        // Работа для третьей фазы
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Поток " + name + " запустился в третьей фазе");
        phaser.arriveAndDeregister(); // завершаем участи потока в фазере

    }
}

class MyThreadWithEnd implements Runnable {
    Phaser phaser;
    String name;

    public MyThreadWithEnd(Phaser phaser, String name) {

        this.phaser = phaser;
        this.name = name;

        phaser.register();
    }

    @Override
    public void run() {

        // небольшая пауза, чтобы не нарушать порядок вывода. Только для демонстрации, в реальности этого может не быть
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Поток " + name + " запустился "+(phaser.getPhase()+1)+" фазе");
        phaser.arriveAndDeregister();
    }
}

