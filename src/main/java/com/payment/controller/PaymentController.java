package com.payment.controller;

import com.payment.model.Transaction;
import com.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

private final PaymentService paymentService;

public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
}

@PostMapping
public Transaction makePayment(
        @RequestParam("customerName") String customerName,
        @RequestParam("paymentType") String paymentType,
        @RequestParam("amount") double amount,
        @RequestParam("paymentDetail") String paymentDetail,
        @RequestParam(value = "bankName", required = false) String bankName) {

    return paymentService.processPayment(
            customerName,
            paymentType,
            amount,
            paymentDetail,
            bankName
    );
}

@GetMapping
public List<Transaction> getTransactions() {
    return paymentService.getAllTransactions();
}

}