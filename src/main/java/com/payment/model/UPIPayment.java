package com.payment.model;

public class UPIPayment extends Payment {

private String upiId;

public UPIPayment(double amount, String upiId) {

    super(amount);

    this.upiId = upiId;
}

@Override
public boolean processPayment() {

    return isValidAmount()
            && isValidUpiId();
}

private boolean isValidUpiId() {

    if (upiId == null || upiId.trim().isEmpty()) {
        return false;
    }

    return upiId.matches(
            "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+$"
    );
}

public String getUpiId() {
    return upiId;
}

}
