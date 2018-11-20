package com.payment.service.dto.dao;


import com.payment.service.dto.beans.Payment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDaoImpl implements PaymentDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addPayment(Payment payment) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        session.save(payment);
    }

    public List<Payment> getPayments() {
        Session session = sessionFactory.getCurrentSession();
        List<Payment> list= session.createCriteria(Payment.class).list();
        return list;
    }

    public Payment findById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Payment payment=(Payment) session.get(Payment.class,id);
        return payment;
    }

    public Payment update(Payment val, String id) {
        Session session = sessionFactory.getCurrentSession();
        Payment payment =(Payment)session.get(Payment.class, id);
        payment.setPayeeid(val.getPayeeid());
        payment.setPayerid(val.getPayerid());
        payment.setPaymentmethodid(val.getPaymentmethodid());
        payment.setCurrency(val.getCurrency());
        payment.setAmount(val.getAmount());
        payment.setPaymentdescription(val.getPaymentdescription());
        payment.setPaymentnumber(val.getPaymentnumber());
        session.update(payment);
        return payment;
    }

    public void delete(String id) {
        Session session = sessionFactory.getCurrentSession();
        Payment payment = findById(id);
        if(payment!=null) {
            session.delete(payment);
        }
    }


    @Override
    public List<Payment> findAllPaymentsByPayerId(String id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Payment.class);
        cr.add(Restrictions.eq("payerid", id));
        return cr.list();
    }

    @Override
    public List<Payment> findAllPaymentsByPayeeId(String id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Payment.class);
        cr.add(Restrictions.eq("payeeid", id));
        return cr.list();
    }

}
