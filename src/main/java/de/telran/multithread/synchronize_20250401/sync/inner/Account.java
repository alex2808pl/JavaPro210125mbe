package de.telran.multithread.synchronize_20250401.sync.inner;

public class Account {
    private int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public synchronized void plusSum(int val) { //синхронизация всего метода
        this.sum+=val; // 10 млсек
        System.out.println("plusSum = "+sum);
        //steps - реальные действия
//        int tmp = this.sum;
//        tmp = tmp + val;
//        this.sum = tmp;
        // инструкции по добавлению транзакции в другу БД(5 сек)
        // инструкции по отправке клиенту уведомления (20 сек)
    }

    public void minusSum(int val) {
        // набор инструкций перед
        synchronized (this) { // синхронизация блока кода
            this.sum-=val; //10 млсек
        }
        System.out.println("minusSum = "+sum);

        //steps - реальные действия
//        int tmp = this.sum;
//        tmp = tmp - val;
//        this.sum = tmp;

        // инструкции по добавлению транзакции в другу БД(5 сек)
        // инструкции по отправке клиенту уведомления (20 сек)
    }
}
