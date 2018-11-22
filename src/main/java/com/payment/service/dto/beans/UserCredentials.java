package com.payment.service.dto.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="user_credentials")
public class UserCredentials implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    /**
     * User id.
     */
    String userid;
    /**
     * Payment id.
     */
    @Id
    @NotNull
    String paymentmethodid;
    /**
     * Payment number of user for payment method id.
     */
    @NotNull
    String paymentnumber;

    /**
     * Default Constructor
     */
    UserCredentials(){

    }

    /**
     * Parameterized Constructor
     */
    UserCredentials(String userid, String paymentmethodid, String paymentnumber){
        super();
        this.userid = userid;
        this.paymentmethodid = paymentmethodid;
        this.paymentnumber = paymentnumber;
    }

    //getters and setters
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPaymentmethodid() {
        return paymentmethodid;
    }

    public void setPaymentmethodid(String paymentmethodid) {
        this.paymentmethodid = paymentmethodid;
    }

    public String getPaymentnumber() {
        return paymentnumber;
    }

    public void setPaymentnumber(String paymentnumber) {
        this.paymentnumber = paymentnumber;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
