package de.telran.multithread.state_20200328;

public class Task extends Thread{
    @Override
    public void run() {
        System.out.println("2."+getState()); //Runnable
        int count = 0;
        for (int i = 0; i < 10_000; i++) {
            if(i % 17 == 0) {
                count++;
                System.out.println("--- 3."+getState()); //Runnable
            }
        }
    }
}
