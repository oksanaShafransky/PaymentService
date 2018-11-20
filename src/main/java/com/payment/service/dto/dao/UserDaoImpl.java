package com.payment.service.dto.dao;

import com.payment.service.dto.beans.Payment;
import com.payment.service.dto.beans.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<User> list= session.createCriteria(User.class).list();
        return list;
    }

    @Override
    public User findById(String id) {
        Session session = sessionFactory.getCurrentSession();
        User user=(User) session.get(User.class,id);
        return user;
    }

    @Override
    public User findByMail(String mail) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.eq("usermail", mail));
        return (User) cr.list().get(0);
    }

    @Override
    public User update(User val, String id) {
        Session session = sessionFactory.getCurrentSession();
        User user =(User)session.get(User.class, id);
        if(user!=null) {
            user.setUsermail(val.getUsermail());
            user.setUsermail(val.getUsername());
            session.update(user);
        }
        return user;
    }

    @Override
    public void delete(String id) {
        Session session = sessionFactory.getCurrentSession();
        User user = findById(id);
        if(user!=null) {
            session.delete(user);
        }
    }
}
