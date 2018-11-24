package com.payment.service.dto.beans;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Identifier of the payment resource created.
     */
    @Id
    private String paymentid;//GUID
    /**
     * User id that payed.
     */
    @NotNull
    @JoinTable(name = "user", joinColumns = @JoinColumn(name = "userid"))
    private String payerid; //user that perform payment - GUID
    /**
     * User id that receives the payment.
     */
    @NotNull
    @JoinTable(name = "user", joinColumns = @JoinColumn(name = "userid"))
    private String payeeid; //user to whom to pay - GUID
    /**
     * Payment method id that represents gateway through which the payment is performed.
     */
    @NotNull
    @JoinTable(name = "paymentmethod", joinColumns = @JoinColumn(name = "paymentmethodid"))
    private String paymentmethodid;//GUID
    /**
     * Sum to be payed - positive number greater then zero.
     */
    @NonNull
    @Positive
    private float  amount;
    /**
     * Currency the payment is performed.
     */
    @NotNull
    private String currency;
    /**
     * Payment description - free text for payment tracking.
     */
    private String paymentdescription;
    /**
     * Payment number - card or bank account number the payment is payed
     */
    @NotNull
    @NotNull
    @JoinTable(name = "usercredentials", joinColumns = @JoinColumn(name = "paymentnumber"))
    private String paymentnumber;
    /**
     * Status of payment, can be FAILED, SUCCEEDED, INPROCESS
     */
    private String paymentstatus;
    /**
     * Payment risk calculated by risk engine
     */
    private String risk;
    /**
     * Payment date - date the payment transaction started
     */
    private String paymentdate;


    /**
     * Parameterized Constructor
     */
    public Payment(String payerid, String currency, float amount, String payeeId, String paymentMethodId, String paymentDescription, String paymentnumber) {
        super();
        this.paymentid = UUID.randomUUID().toString();
        this.amount = amount;
        this.currency = currency;
        this.payerid = payerid;
        this.payeeid = payeeId;
        this.paymentmethodid = paymentMethodId;
        this.paymentdescription = paymentDescription;
        this.paymentnumber = paymentnumber;
    }
    /**
     * Default Constructor
     */
    public Payment(){

    }

    //getters and setters
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

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String status) {
        this.paymentstatus = status;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(String date) {
        this.paymentdate = date;
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
                ", amount=" + amount + ", currency=" + currency + ", paymentnumber=" + paymentnumber + "]";
    }
}
