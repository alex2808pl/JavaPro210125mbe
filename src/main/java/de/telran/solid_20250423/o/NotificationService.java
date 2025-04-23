package de.telran.solid_20250423.o;
//Open/closed principle – принцип открытости/закрытости
//        (программные сущности должны быть закрыты для изменения,
//        но открыты для расширения);

// O - нарушаем, т.к. приходиться править код, для добавляния нового источника передачи
public class NotificationService {
    public void sendMessage(String typeMessage, String message) { //отправка сообщения
        if (typeMessage.equals("email")) {
            //write email
            //use JavaMailSenderAPI
        }
        // новый код
        if (typeMessage.equals("sms")) {
            //write sms
            //use SMS sender
        }
        // новый код
        if (typeMessage.equals("telegram")) {
            //write message
            //use Telegram sender
        }
    }
}
