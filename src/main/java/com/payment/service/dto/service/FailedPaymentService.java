package com.payment.service.dto.service;

import com.payment.service.dto.beans.FailedPayment;
import com.payment.service.dto.beans.Payment;

import java.util.List;

public interface FailedPaymentService {
    FailedPayment getPaymentById(String id);
    List<FailedPayment> getAllPayments();
    boolean addPayment(FailedPayment payment);
    void updatePayment(FailedPayment payment);
    void deletePayment(String paymentId);
    List<FailedPayment> getAllPaymentsByPayeeId(String id);
    List<FailedPayment> getAllPaymentsByPayerId(String id);
}


