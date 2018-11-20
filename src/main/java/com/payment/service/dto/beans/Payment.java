package com.payment.service.dto.beans;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String paymentid;//GUID
    @NotNull
    private String payerid; //user that perform payment - GUID
    @NotNull
    private String payeeid; //user to whom to pay - GUID
    @NotNull
    private String paymentmethodid;//GUID
    @NonNull
    @Positive(message = "Amount must be positive number greater zero")
    private float  amount;
    @NotNull
    private String currency;
    private String paymentdescription;
    @NotNull(message = "Insert payment number")
    private String paymentnumber;

    public Payment(String userId, String currency, float amount, String payeeId, String paymentMethodId, String paymentDescription) {
        super();
        this.paymentid = UUID.randomUUID().toString();
        this.amount = amount;
        this.currency = currency;
        this.payerid = userId;
        this.payeeid = payeeId;
        this.paymentmethodid = paymentMethodId;
        this.paymentdescription = paymentDescription;
    }
    public Payment(){

    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentId) {
        this.paymentid = paymentId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPayerid() {
        return payerid;
    }

    public void setPayerid(String userId) {
        this.payerid = userId;
    }

    public String getPayeeid() {
        return payeeid;
    }

    public void setPayeeid(String payeeid) {
        this.payeeid = payeeid;
    }

    public String getPaymentmethodid() {
        return paymentmethodid;
    }

    public void setPaymentmethodid(String paymentmethodid) {
        this.paymentmethodid = paymentmethodid;
    }

    public String getPaymentdescription() {
        return paymentdescription;
    }

    public void setPaymentdescription(String paymentDescription) {
        this.paymentdescription = paymentDescription;
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

    @Override
    public String toString() {
        return "Payment [paymentid=" + paymentid + ", payerid=" + payerid + ", payeeid=" + payeeid +
                ", paymentdescription=" + paymentdescription + ", paymentmethodid=" + paymentmethodid +
                ", amount=" + amount + ", currency=" + currency +"]";
    }
}
