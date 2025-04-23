package de.telran.solid_20250423.o.refactor;

public class MainNotification {
    public static void main(String[] args) {
        NotificationService message = new EmailNotification();
        message.sendMessage("Заберите товар!");
        message.prepareMessage("Заберите товар!");

        // новая функциональность
        message = new SMSNotification();
        message.sendMessage("Заберите товар!");
        message.prepareMessage("Заберите товар!");

        // новая функциональность
        message = new TelegramNotification();
        message.sendMessage("Заберите товар!");
    }
}
