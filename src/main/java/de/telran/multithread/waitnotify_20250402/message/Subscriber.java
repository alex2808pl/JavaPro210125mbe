package de.telran.multithread.waitnotify_20250402.message;

public class  Subscriber implements Runnable{
    private Message msg;

    public Subscriber(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                System.out.println(name + " ждет сообщения (notify): "+System.currentTimeMillis());
                msg.wait();
                //msg.wait(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " начинаем обрабатывать сообщение (notify): "+System.currentTimeMillis());
            // обрабатывам сообщение
            System.out.println(name+" обработал =====> "+msg.getMsg());
            System.out.println(name + " закончил обрабатывать сообщение (notify): "+System.currentTimeMillis());
        }
    }
}
