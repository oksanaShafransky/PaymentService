package com.payment.service.dto.service;

import com.payment.service.dto.beans.PaymentMethod;
import com.payment.service.dto.beans.User;
import com.payment.service.dto.dao.PaymentMethodDao;
import com.payment.service.dto.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    private PaymentMethodDao paymentMethodDao;

    @Override
    public PaymentMethod getPaymentMethodById(String id) {
        return paymentMethodDao.findPaymentMethodById(id);
    }

    @Override
    public PaymentMethod getPaymentMethodByName(String name) {
        return paymentMethodDao.getPaymentMethodByName(name);
    }

    @Override
    public List<PaymentMethod> getAllPaymentMethods() {
        return (List<PaymentMethod>) paymentMethodDao.getPaymentMethods();
    }

}
