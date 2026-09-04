package com.payment.model;

public class NetBankingPayment extends Payment {

private String bankName;
private String accountNumber;

public NetBankingPayment(
        double amount,
        String bankName,
        String accountNumber) {

    super(amount);

    this.bankName = bankName;
    this.accountNumber = accountNumber;
}

@Override
public boolean processPayment() {

    return isValidAmount()
            && isValidBank()
            && isValidAccountNumber();
}

private boolean isValidBank() {

    return bankName != null
            && !bankName.trim().isEmpty();
}

private boolean isValidAccountNumber() {

    if (accountNumber == null) {
        return false;
    }

    String cleanAccountNumber =
            accountNumber.replaceAll("\\D", "");

    return cleanAccountNumber.length() >= 9
            && cleanAccountNumber.length() <= 18;
}

public String getBankName() {
    return bankName;
}

public String getAccountNumber() {
    return accountNumber;
}

}
