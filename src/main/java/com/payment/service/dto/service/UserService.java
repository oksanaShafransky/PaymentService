package com.payment.service.dto.service;

import com.payment.service.dto.beans.User;

import java.util.List;

public interface UserService {
    User getUserById(String id);
    User getUserByMail(String mail);
    List<User> getAllUsers();
    boolean addUser(User user);
    void updateUser(User user);
    void deleteUser(String userid);
    User authenticateUser(String usermail, String userpassword);
}
