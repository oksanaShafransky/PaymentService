package com.payment.service.dto.service;

import com.payment.service.dto.beans.FailedPayment;
import com.payment.service.dto.beans.Payment;
import com.payment.service.dto.dao.FailedPaymentDao;
import com.payment.service.dto.dao.PaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FailedPaymentServiceImpl implements FailedPaymentService {
    @Autowired
    private FailedPaymentDao paymentDao;

    @Override
    public FailedPayment getPaymentById(String id) {
        FailedPayment obj = paymentDao.findById(id);
        return obj;
    }

    @Override
    public List<FailedPayment> getAllPayments() {
        return (List<FailedPayment>) paymentDao.getPayments();
    }

    @Override
    public synchronized boolean addPayment(FailedPayment payment) {
        try {
            paymentDao.addPayment(payment);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public void updatePayment(FailedPayment payment) {
        paymentDao.update(payment, payment.getPaymentid());
    }

    @Override
    public void deletePayment(String paymentId) {
        paymentDao.delete(paymentId);
    }

    @Override
    public List<FailedPayment> getAllPaymentsByPayeeId(String id) {
        return paymentDao.findAllPaymentsByPayeeId(id);
    }

    @Override
    public List<FailedPayment> getAllPaymentsByPayerId(String id) {
        return paymentDao.findAllPaymentsByPayerId(id);
    }
}
