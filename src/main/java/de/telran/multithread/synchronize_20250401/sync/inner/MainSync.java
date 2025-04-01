package de.telran.multithread.synchronize_20250401.sync.inner;

public class MainSync {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        Account account1 = new Account();
        Thread father = new PlusThread(account, 10);
        Thread child = new MinusThread(account, 10);

        System.out.println("До = "+account.getSum());

        father.start(); // + 1 млн.
        child.start(); // - 1 млн.

        father.join();
        child.join();

        System.out.println("После = "+account.getSum());
    }
}
