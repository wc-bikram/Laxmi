package com.Laxmi.financeManager.entity;


import jakarta.persistence.Entity;

@Entity
public class PremiumUser extends User {

    private String subscriptionType;  // Additional field for PremiumUser

    // Constructors
    public PremiumUser() {}

    public PremiumUser(String name, String email, String password, String subscriptionType) {
        super(name, email, password);
        this.subscriptionType = subscriptionType;
    }

    // Getter and Setter for subscriptionType
    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}