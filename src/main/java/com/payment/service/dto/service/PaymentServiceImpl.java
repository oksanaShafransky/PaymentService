package com.payment.service.dto.service;

import com.payment.service.dto.beans.Payment;
import com.payment.service.dto.dao.PaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Payment getPaymentById(String id) {
        Payment obj = paymentDao.findById(id);
        return obj;
    }

    @Override
    public List<Payment> getAllPayments() {
        return (List<Payment>) paymentDao.getPayments();
    }

    @Override
    public synchronized boolean addPayment(Payment payment) {
        try {
            paymentDao.addPayment(payment);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public void updatePayment(Payment payment) {
        paymentDao.update(payment, payment.getPaymentid());
    }

    @Override
    public void deletePayment(String paymentId) {
        paymentDao.delete(paymentId);
    }

    @Override
    public List<Payment> getAllPaymentsByPayeeId(String id) {
        return paymentDao.findAllPaymentsByPayeeId(id);
    }

    @Override
    public List<Payment> getAllPaymentsByPayerId(String id) {
        return paymentDao.findAllPaymentsByPayerId(id);
    }
}
