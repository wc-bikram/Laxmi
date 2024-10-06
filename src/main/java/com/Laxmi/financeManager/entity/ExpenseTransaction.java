package com.Laxmi.financeManager.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class ExpenseTransaction extends Transaction {

    private String expenseType;

    public ExpenseTransaction() {}

    public ExpenseTransaction(double amount, String description, String expenseType) {
        super(amount, description, LocalDate.now());
        this.expenseType = expenseType;
    }

    @Override
    public void execute() {
        // Logic specific to expense transactions
        System.out.println("Processing expense transaction");
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }
}