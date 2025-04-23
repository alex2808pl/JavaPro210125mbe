package de.telran.solid_20250423.o.refactor;

public class EmailNotification implements NotificationService{
    @Override
    public void sendMessage(String message) {
        System.out.println("Отправили по EMail ->"+message);
    }

    @Override
    public void prepareMessage(String message) {
        System.out.println("Готовим сообщение в EmailNotification");
    }
}
