package de.telran.exception_20250314;
// uncheck
public class UserUncheckedException extends RuntimeException{
    public UserUncheckedException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "(uncheck) UserUncheckedException{} " + super.toString();
    }
}
