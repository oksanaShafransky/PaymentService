package com.payment.service.dto.dao;

import com.payment.service.dto.beans.Payment;
import com.payment.service.dto.beans.PaymentMethod;
import com.payment.service.dto.beans.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentMethodDaoImpl implements PaymentMethodDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PaymentMethod> getPaymentMethods() {
        Session session = sessionFactory.getCurrentSession();
        List<PaymentMethod> list= session.createCriteria(PaymentMethod.class).list();
        return list;
    }

    @Override
    public PaymentMethod getPaymentMethodByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(PaymentMethod.class);
        cr.add(Restrictions.eq("methodname", name));
        return (PaymentMethod) cr.list().get(0);
    }

    @Override
    public PaymentMethod findPaymentMethodById(String id) {
        Session session = sessionFactory.getCurrentSession();
        PaymentMethod paymentMethod=(PaymentMethod) session.get(PaymentMethod.class,id);
        return paymentMethod;
    }

}
