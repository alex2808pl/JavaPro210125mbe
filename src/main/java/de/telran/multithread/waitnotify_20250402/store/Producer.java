package de.telran.multithread.waitnotify_20250402.store;

public class Producer implements Runnable {
    private Store store;
    Producer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 10; i++) {
            store.put();
            try { //имитируем раздумие производителя
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
