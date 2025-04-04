package de.telran.multithread.syncronizators_20250404.count_down_latch;

import java.util.concurrent.CountDownLatch;

public class MainCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        // список людей, кто желает полететь на отдых
        String[] personNames = new String[]{"Roman", "Alena", "Kira", "Anna", "Leo", "Bob", "Vladislav", "Inna"};

        CountDownLatch countDownLatch = new CountDownLatch(personNames.length);

        for (int i = 0; i < personNames.length; i++) {
            new Thread(new PersonInAirport(personNames[i], countDownLatch)).start();
            Thread.sleep(500);
        }

        System.out.println("===== Главный поток завершился! =======");
    }
}

class PersonInAirport implements Runnable {
    private String personName;
    private CountDownLatch countDownLatch;

    public PersonInAirport(String personName, CountDownLatch countDownLatch) {
        this.personName = personName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            // список дел, которые буду выполнены в рамках каждого потока (человека) самостоятельно
            System.out.println("-> " + personName + " приехал в аэропорт.");
            System.out.println("[!] " + personName + " сдал багаж");
            System.out.println("[!] " + personName + " успел перекусить");

            countDownLatch.countDown(); //-1

            System.out.println(personName+" ожидает других.");
            countDownLatch.await(); // когда count==0 все выходят из состояния ожидания

            // финальное - выполнится то, что находится после await() метода
            System.out.println(personName + " с группой пошел на посадку в самолет");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
