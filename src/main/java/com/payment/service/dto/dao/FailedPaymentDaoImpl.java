package com.payment.service.dto.dao;


import com.payment.service.dto.beans.FailedPayment;
import com.payment.service.dto.beans.Payment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FailedPaymentDaoImpl implements FailedPaymentDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addPayment(FailedPayment payment) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        session.save(payment);
    }

    public List<FailedPayment> getPayments() {
        Session session = sessionFactory.getCurrentSession();
        List<FailedPayment> list= session.createCriteria(FailedPayment.class).list();
        return list;
    }

    public FailedPayment findById(String id) {
        Session session = sessionFactory.getCurrentSession();
        FailedPayment payment=(FailedPayment) session.get(FailedPayment.class,id);
        return payment;
    }

    public FailedPayment update(FailedPayment val, String id) {
        Session session = sessionFactory.getCurrentSession();
        FailedPayment payment =(FailedPayment)session.get(FailedPayment.class, id);
        payment.setPayeeid(val.getPayeeid());
        payment.setPayerid(val.getPayerid());
        payment.setPaymentmethodid(val.getPaymentmethodid());
        payment.setCurrency(val.getCurrency());
        payment.setAmount(val.getAmount());
        payment.setPaymentdescription(val.getPaymentdescription());
        payment.setPaymentnumber(val.getPaymentnumber());
        payment.setPaymentstatus(val.getPaymentstatus());
        payment.setRisk(val.getRisk());
        session.update(payment);
        return payment;
    }

    public void delete(String id) {
        Session session = sessionFactory.getCurrentSession();
        FailedPayment payment = findById(id);
        if(payment!=null) {
            session.delete(payment);
        }
    }


    @Override
    public List<FailedPayment> findAllPaymentsByPayerId(String id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(FailedPayment.class);
        cr.add(Restrictions.eq("payerid", id));
        return cr.list();
    }

    @Override
    public List<FailedPayment> findAllPaymentsByPayeeId(String id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(FailedPayment.class);
        cr.add(Restrictions.eq("payeeid", id));
        return cr.list();
    }

}
