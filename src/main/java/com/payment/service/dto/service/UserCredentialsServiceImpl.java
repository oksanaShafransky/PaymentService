package com.payment.service.dto.service;

import com.payment.service.dto.beans.User;
import com.payment.service.dto.beans.UserCredentials;
import com.payment.service.dto.dao.UserCredentialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserCredentialsServiceImpl implements UserCredentialsService {
    @Autowired
    private UserCredentialDao userCredentialDao;

    @Override
    public List<UserCredentials> getByPaymentMethodId(String id) {
        return userCredentialDao.findByPaymentMethodId(id);
    }

    @Override
    public List<UserCredentials> getByUserId(String id) {
        return userCredentialDao.findByUserId(id);
    }

    @Override
    public List<UserCredentials> getAllUserCredentials() {
        return (List<UserCredentials>) userCredentialDao.getUserCredentials();
    }
}
