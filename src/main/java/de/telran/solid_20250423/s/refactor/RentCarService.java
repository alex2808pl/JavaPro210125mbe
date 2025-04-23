package de.telran.solid_20250423.s.refactor;
//S - Single Responsibility Principle - принцип единственной ответственности.
// Каждый класс должен иметь только одну зону ответственности.


import de.telran.solid_20250423.s.Client;
import de.telran.solid_20250423.s.Order;

public class RentCarService {

    public Order orderCar(String carNo, Client client) {  // создание заказа на авто
        //client order car
        Order order = new Order();
        // .... код ..........
        return order;
    }

}
