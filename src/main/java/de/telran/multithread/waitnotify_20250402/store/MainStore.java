package de.telran.multithread.waitnotify_20250402.store;

public class MainStore {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer1 = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer1).start();
    }
}
