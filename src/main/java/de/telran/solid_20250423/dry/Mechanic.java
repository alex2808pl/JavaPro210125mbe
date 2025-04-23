package de.telran.solid_20250423.dry;

public class Mechanic {
    public void serviceBus() {
        System.out.println("Servicing bus now");
        //System.out.println("Washing..."); // дублирование кода, не соответствие DRY
    }
    public void serviceCar() {
        System.out.println("Servicing car now");
        //System.out.println("Washing..."); // дублирование кода, не соответствие DRY
    }

    // Выделяем в отдельный метод дублирующий код
    public void washVehicle() {
        System.out.println("Washing...!!!");
    }

    public static void main(String[] args) {
        Mechanic mechanic = new Mechanic();
        mechanic.serviceBus();
        mechanic.washVehicle();
        mechanic.serviceCar();
        mechanic.washVehicle();
    }
}
