package com.payment.service.dto.service;

import com.payment.service.dto.beans.User;
import com.payment.service.dto.beans.UserCredentials;

import java.util.List;

public interface UserCredentialsService {
    List<UserCredentials> getByPaymentMethodId(String id);
    List<UserCredentials> getByUserNameAndByPaymentMethodId(String userid, String methodid);
    List<UserCredentials> getByUserId(String id);
    List<UserCredentials> getAllUserCredentials();
}
