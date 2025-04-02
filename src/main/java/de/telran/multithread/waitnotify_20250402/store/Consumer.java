package de.telran.multithread.waitnotify_20250402.store;

public class Consumer implements Runnable{

    private Store store;
    Consumer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 10; i++) {
            store.get(); // забирать товар
            try { //имитируем раздумие покупателя
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
