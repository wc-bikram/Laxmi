package com.Laxmi.financeManager.budget;

public interface BudgetManager {
    void setMonthlyIncome(double income);
    void setBudgetLimit(double limit);
    double getRemainingBudget(double currentSpending);
    String suggestSavingsPlan(double savingsGoal);
}
