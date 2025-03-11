package de.telran.generic_20250311;

public class AccountObject {
    private Object id;
    private int sum;

    public AccountObject(Object id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    public Object getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
