package de.telran.solid_20250423.i.refactor;

public class InternetPaymentService implements WebMoneyPayment, CreditCardPayment, PhoneNumberPayment{
    @Override
    public void payWebMoney() {
        //logic
    }
    @Override
    public void payCreditCard() {
        //logic
    }
    @Override
    public void payPhoneNumber() {
        //logic
    }
}
