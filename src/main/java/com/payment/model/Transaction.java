package com.payment.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String paymentType;
    private double amount;
    private String status;
    private LocalDateTime transactionDate;

    public Transaction() {
    }

    public Transaction(String customerName, String paymentType,
                       double amount, String status) {
        this.customerName = customerName;
        this.paymentType = paymentType;
        this.amount = amount;
        this.status = status;
        this.transactionDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}