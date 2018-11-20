package com.payment.service.dto.dao;

import com.payment.service.dto.beans.User;
import com.payment.service.dto.beans.UserCredentials;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserCredentialsDaoImpl implements UserCredentialDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserCredentials> getUserCredentials() {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<UserCredentials> list= session.createCriteria(UserCredentials.class).list();
        return list;
    }

    @Override
    public List<UserCredentials> findByUserId(String id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(UserCredentials.class);
        cr.add(Restrictions.eq("userid", id));
        return cr.list();
    }

    @Override
    public List<UserCredentials> findByPaymentMethodId(String id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(UserCredentials.class);
        cr.add(Restrictions.eq("paymentmethodid", id));
        return cr.list();
    }

}
