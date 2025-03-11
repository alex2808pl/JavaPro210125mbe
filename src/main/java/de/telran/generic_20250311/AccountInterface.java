package de.telran.generic_20250311;

public class AccountInterface<T> implements AccountVisible<T>{
    private T id;
    private int sum;

    @Override
    public T getId() {
        return null;
    }

    @Override
    public int getSum() {
        return 0;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public AccountInterface(T id, int sum) {
        this.id = id;
        this.sum = sum;
    }
}
