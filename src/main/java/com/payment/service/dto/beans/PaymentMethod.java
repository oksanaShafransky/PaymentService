package com.payment.service.dto.beans;

//import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="paymentmethod")
public class PaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    /**
     * Payment method unique identifier.
     */
    private String paymentmethodid; //GUID
    /**
     * Payment method name.
     */
    @NotNull
    private String methodname;

    /**
     * Default Constructor
     */
    public PaymentMethod(){

    }

    /**
     * Parameterized Constructor
     */
    public PaymentMethod(String methodname){
        super();
        this.paymentmethodid = UUID.randomUUID().toString();
        this.methodname = methodname;
    }

    //getters and setters
    public String getPaymentmethodid() {
        return paymentmethodid;
    }

    public void setPaymentmethodid(String paymentmethodid) {
        this.paymentmethodid = paymentmethodid;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
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
