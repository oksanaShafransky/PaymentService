package com.payment.service.dto.service;

import com.payment.service.dto.beans.Payment;

import java.util.List;

public interface PaymentService{
    Payment getPaymentById(String id);
    List<Payment> getAllPayments();
    boolean addPayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(String paymentId);
    List<Payment> getAllPaymentsByPayeeId(String id);
    List<Payment> getAllPaymentsByPayerId(String id);
}


