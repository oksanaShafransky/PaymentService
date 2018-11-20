package com.payment.service.dto.dao;

import com.payment.service.dto.beans.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public List<User> getUsers();
    public User findById(String id);
    public User findByMail(String mail);
    public User update(User user, String id);
    public void delete(String id);
}
