package com.payment.service.dto.dao;

import com.payment.service.dto.beans.User;
import com.payment.service.dto.beans.UserCredentials;

import java.util.List;

public interface UserCredentialDao {
    public List<UserCredentials> getUserCredentials();
    public List<UserCredentials> findByUserId(String id);
    public List<UserCredentials> findByPaymentMethodId(String id);
}
