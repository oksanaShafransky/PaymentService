package com.payment.service.dto.service;

import com.payment.service.dto.beans.PaymentMethod;
import com.payment.service.dto.beans.User;

import java.util.List;

public interface PaymentMethodService {
    PaymentMethod getPaymentMethodById(String id);
    PaymentMethod getPaymentMethodByName(String name);
    List<PaymentMethod> getAllPaymentMethods();
}
