package de.telran.exception_20250314;

// отслеживаемое исключение
public class UserCheckedException extends Exception {
    public UserCheckedException(String message) {
        super(message);
    }
}
