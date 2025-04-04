package de.telran.multithread.waitnotify_20250402.ht;

import de.telran.multithread.waitnotify_20250402.store.Consumer;
import de.telran.multithread.waitnotify_20250402.store.Producer;
import de.telran.multithread.waitnotify_20250402.store.Store;

public class MainRobot {
    public static void main(String[] args) {
        Desk desk = new Desk();
        RobotPut robotPut = new RobotPut(desk);
        RobotGet robotGet = new RobotGet(desk);
        new Thread(robotPut).start();
        new Thread(robotGet).start();
    }
}


