package com.Laxmi.financeManager.entity;


import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class IncomeTransaction extends Transaction {

    private String incomeSource;

    public IncomeTransaction() {}

    public IncomeTransaction(double amount, String description, String incomeSource) {
        super(amount, description, LocalDate.now());
        this.incomeSource = incomeSource;
    }

    @Override
    public void execute() {
        // Logic specific to income transactions
        System.out.println("Processing income transaction");
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }
}