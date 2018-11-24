package com.payment.service.dto.beans;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;
import javax.validation.constraints.Email;

@Entity
@Table(name="user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * User identifier for payment system.
     */
    @Id
    @NotNull
    private String userid;
    /**
     * User name.
     */
    @NonNull
    private String username;

    /**
     * User password.
     */
    @NonNull
    private String userpassword;
    /**
     * User mail.
     */
    @Email(message = "Email should be valid")
    private String usermail;
    /**
     * User address.
     */
    @NonNull
    private String useraddress;

    /**
     * Default Constructor
     */
    public User(){

    }

    /**
     * Parameterized Constructor
     */
    public User(String userid, String username, String userpassword, String usermail,String useraddress){
        super();
        this.userid = UUID.randomUUID().toString();
        this.username = username;
        this.userpassword=userpassword;
        this.useraddress=useraddress;
        this.usermail = usermail;
    }

    //setters and getters
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) { this.usermail = usermail; }
    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
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
