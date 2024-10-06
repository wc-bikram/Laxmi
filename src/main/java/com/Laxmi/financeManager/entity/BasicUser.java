package com.Laxmi.financeManager.entity;

import jakarta.persistence.Entity;

@Entity
public class BasicUser extends User {

    private boolean limitedAccess;  // Additional field for BasicUser

    // Constructors
    public BasicUser() {}

    public BasicUser(String name, String email, String password, boolean limitedAccess) {
        super(name, email, password);
        this.limitedAccess = limitedAccess;
    }

    // Getter and Setter for limitedAccess
    public boolean isLimitedAccess() {
        return limitedAccess;
    }

    public void setLimitedAccess(boolean limitedAccess) {
        this.limitedAccess = limitedAccess;
    }
}