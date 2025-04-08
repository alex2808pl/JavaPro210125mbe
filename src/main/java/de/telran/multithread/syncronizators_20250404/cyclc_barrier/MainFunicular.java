package de.telran.multithread.syncronizators_20250404.cyclc_barrier;

import java.util.concurrent.CyclicBarrier;

public class MainFunicular {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Funicular());

        // список людей, кто желает забраться на вершину горы
        String[] personNames = new String[]{"Roman", "Alena", "Kira", "Anna", "Leo", "Bob", "Vladislav", "Inna"};

        for (int i = 0; i < personNames.length; i++) {
            new Thread(new PersonOnFunicular(personNames[i], cyclicBarrier)).start();
            Thread.sleep(400);
        }
    }
}

class PersonOnFunicular implements Runnable {

    private String personName;
    private CyclicBarrier cyclicBarrier;

    public PersonOnFunicular(String personName, CyclicBarrier cyclicBarrier) {
        this.personName = personName;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("-> " + personName + " жду на платформе");
            cyclicBarrier.await(); //-1
            System.out.println("<- " + personName + " на вершине");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Funicular implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("Фуникулер взял несколько человек и едет на вершину холма");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}