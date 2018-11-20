package com.payment.service.dto.dao;

import com.payment.service.dto.beans.PaymentMethod;
import com.payment.service.dto.beans.User;

import java.util.List;

public interface PaymentMethodDao {
    public PaymentMethod findPaymentMethodById(String id);
    public List<PaymentMethod> getPaymentMethods();
    public PaymentMethod getPaymentMethodByName(String name);
}
