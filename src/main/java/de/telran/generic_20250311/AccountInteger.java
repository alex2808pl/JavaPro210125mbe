package de.telran.generic;

public class AccountInteger implements AccountVisible<Integer>{
    private Integer id;
    private int sum;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public int getSum() {
        return sum;
    }

    public AccountInteger(Integer id, int sum) {
        this.id = id;
        this.sum = sum;
    }
}
