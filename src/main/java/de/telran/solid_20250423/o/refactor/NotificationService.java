package de.telran.solid_20250423.o.refactor;

public interface NotificationService {
    void sendMessage(String message);
    default void prepareMessage(String message) {
        System.out.println("Готовим сообщение в интерфейсе");
    }
}
