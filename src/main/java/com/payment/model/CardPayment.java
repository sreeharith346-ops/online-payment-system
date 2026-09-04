package com.payment.model;

public class CardPayment extends Payment {

private String cardNumber;
private String cardHolderName;

public CardPayment(
        double amount,
        String cardNumber,
        String cardHolderName) {

    super(amount);

    this.cardNumber = cardNumber;
    this.cardHolderName = cardHolderName;
}

@Override
public boolean processPayment() {

    return isValidAmount()
            && isValidCardNumber()
            && isValidCardHolder();
}

private boolean isValidCardNumber() {

    if (cardNumber == null) {
        return false;
    }

    String cleanCardNumber =
            cardNumber.replaceAll("\\s", "");

    return cleanCardNumber.matches("\\d{16}");
}

private boolean isValidCardHolder() {

    return cardHolderName != null
            && cardHolderName.trim().length() >= 3;
}

public String getCardNumber() {
    return cardNumber;
}

public String getCardHolderName() {
    return cardHolderName;
}

}