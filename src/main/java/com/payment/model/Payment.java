package com.payment.model;

public abstract class Payment {

private double amount;

public Payment(double amount) {
    this.amount = amount;
}

// Encapsulation
public double getAmount() {
    return amount;
}

public void setAmount(double amount) {
    this.amount = amount;
}

// Abstraction
public abstract boolean processPayment();

// Common method inherited by all payment types
public void displayPaymentDetails() {
    System.out.println("Payment Amount: ₹" + amount);
}

// Common validation for all payment methods
protected boolean isValidAmount() {
    return amount > 0;
}

}