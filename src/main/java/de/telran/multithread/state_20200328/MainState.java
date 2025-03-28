package de.telran.multithread.state_20200328;

public class MainState {
    public static void main(String[] args) throws InterruptedException {
        Task t1 = new Task();
        System.out.println("Before start -> "+ t1.getState());

        t1.start();

        t1.join();

        System.out.println("After join -> "+ t1.getState());

        System.out.println(" - End main thread - ");

    }
}
