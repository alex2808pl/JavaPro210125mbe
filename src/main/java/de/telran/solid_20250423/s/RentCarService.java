package de.telran.solid_20250423.s;
//S - Single Responsibility Principle - принцип единственной ответственности.
// Каждый класс должен иметь только одну зону ответственности.

// Данный класс не соответствует принципу S
public class RentCarService {

    // поиск авто
    public Car findCar(String carNo) {
        //find car by number
        Car car = new Car();
        // .... код ..........
        return car;
    }

    public Order orderCar(String carNo, Client client) {  // создание заказа на авто
        //client order car
        Order order = new Order();
        // .... код ..........
        return order;
    }

    public void printOrder(Order order) { //печать заказа
        //print order
    }

    public void getCarInterestInfo(String carType) { // поиск по желанию
        if (carType.equals("sedan")) {
            //do some job
        }
        if (carType.equals("pickup")) {
            //do some job
        }
        if (carType.equals("van")) {
            //do some job
        }
    }

    public void sendMessage(String typeMessage, String message) { //отправка сообщения
        if (typeMessage.equals("email")) {
            //write email
            //use JavaMailSenderAPI
        }
    }

}
