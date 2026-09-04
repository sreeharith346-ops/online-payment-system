package com.payment.service;

import com.payment.model.CardPayment;
import com.payment.model.NetBankingPayment;
import com.payment.model.Payment;
import com.payment.model.Transaction;
import com.payment.model.UPIPayment;
import com.payment.repository.TransactionRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

private final TransactionRepository transactionRepository;

public PaymentService(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
}

public Transaction processPayment(
        String customerName,
        String paymentType,
        double amount,
        String paymentDetail,
        String bankName) {

    Payment payment;

    if (paymentType.equalsIgnoreCase("CARD")) {

        payment = new CardPayment(
                amount,
                paymentDetail,
                customerName
        );

    } else if (paymentType.equalsIgnoreCase("UPI")) {

        payment = new UPIPayment(
                amount,
                paymentDetail
        );

    } else if (paymentType.equalsIgnoreCase("NETBANKING")) {

        payment = new NetBankingPayment(
                amount,
                bankName,
                paymentDetail
        );

    } else {

        throw new IllegalArgumentException(
                "Invalid payment type: " + paymentType
        );
    }

    // Polymorphism
    boolean success = payment.processPayment();

    String status;

    if (success) {
        status = "SUCCESS";
    } else {
        status = "FAILED";
    }

    Transaction transaction = new Transaction(
            customerName,
            paymentType.toUpperCase(),
            amount,
            status
    );

    return transactionRepository.save(transaction);
}

public List<Transaction> getAllTransactions() {
    return transactionRepository.findAll();
}

}