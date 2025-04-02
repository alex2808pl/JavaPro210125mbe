package de.telran.multithread.waitnotify_20250402.message;

// публикует сообщение
public class Publisher implements Runnable {
    private Message msg;

    public Publisher(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал.");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                System.out.println(name + " создал сообщение.");
                msg.setMsg(name+"  ->  Это сообщение N1!");
//                msg.notify(); // один поток получит сигнал
                msg.notifyAll(); // все потоки, который в wait получат сигнал
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}