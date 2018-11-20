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
    @Id
    @NotNull
    private String userid;
    @NonNull
    private String username;
    @Email(message = "Email should be valid")
    private String usermail;

    public User(){

    }

    public User(String userid, String username, String usermail){
        super();
        this.userid = UUID.randomUUID().toString();
        this.username = username;
        this.usermail = usermail;
    }

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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
