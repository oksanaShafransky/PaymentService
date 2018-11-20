package com.payment.service.dto.dao;

import com.payment.service.dto.beans.Payment;

import java.util.List;

public interface PaymentDao {
    public void addPayment(Payment payment);
    public List<Payment> getPayments();
    public Payment findById(String id);
    public Payment update(Payment payment, String id);
    public void delete(String id);
    public List<Payment> findAllPaymentsByPayerId(String id);
    public List<Payment> findAllPaymentsByPayeeId(String id);
}
