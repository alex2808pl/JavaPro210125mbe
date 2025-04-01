package de.telran.multithread.synchronize_20250401.lock;

public class Account {
    private int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void plusSum(int val) {
        this.sum += val;
    }

    public void minusSum(int val) {
        this.sum -= val;
    }
}
