package com.payment.service.dto.dao;

import com.payment.service.dto.beans.FailedPayment;
import com.payment.service.dto.beans.Payment;

import java.util.List;

public interface FailedPaymentDao {
    public void addPayment(FailedPayment payment);
    public List<FailedPayment> getPayments();
    public FailedPayment findById(String id);
    public FailedPayment update(FailedPayment payment, String id);
    public void delete(String id);
    public List<FailedPayment> findAllPaymentsByPayerId(String id);
    public List<FailedPayment> findAllPaymentsByPayeeId(String id);
}
