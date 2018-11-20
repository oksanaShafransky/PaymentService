package com.payment.service.dto.service;

import com.payment.service.dto.beans.User;
import com.payment.service.dto.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(String id) {
        return userDao.findById(id);
    }

    @Override
    public User getUserByMail(String mail) {
        return userDao.findByMail(mail);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userDao.getUsers();
    }

    @Override
    public boolean addUser(User user) {
        try {
            userDao.addUser(user);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user, user.getUserid());
    }

    @Override
    public void deleteUser(String userId) {
        userDao.delete(userId);
    }

}
