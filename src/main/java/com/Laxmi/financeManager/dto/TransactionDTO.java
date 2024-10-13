package com.Laxmi.financeManager.dto;

public class TransactionDTO {
    private double amount;
    private String description;

    // Constructors
    public TransactionDTO(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    // Setters (if needed)
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
