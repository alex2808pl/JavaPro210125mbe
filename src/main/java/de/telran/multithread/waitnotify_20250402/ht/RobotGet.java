package de.telran.multithread.waitnotify_20250402.ht;

public class RobotGet implements Runnable {
    private Desk desk;
    RobotGet(Desk desk){
        this.desk=desk;
    }

    public void run(){
        for (int i = 1; i < 10; i++) {
            try {
                desk.get();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
