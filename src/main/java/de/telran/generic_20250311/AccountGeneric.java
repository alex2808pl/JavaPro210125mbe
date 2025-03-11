package de.telran.generic;

public class AccountGeneric<T> {
    private T id;
    private int sum;

    public AccountGeneric(T id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    public T getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
