package de.telran.solid_20250423.i;

//Interface segregation principle – принцип разделения интерфейса
//        (много специализированных интерфейсов лучше, чем один универсальный);

// i - нарущение, т.к. есть один большой универсальный интерфейс
public interface Payments {
    void payWebMoney();
    void payCreditCard();
    void payPhoneNumber();
}
