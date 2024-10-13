package com.Laxmi.financeManager.budget;
import com.Laxmi.financeManager.entity.BasicUser;
import com.Laxmi.financeManager.entity.PremiumUser;
import com.Laxmi.financeManager.entity.Transaction;
import com.Laxmi.financeManager.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AIRecommender implements BudgetManager {

    private double monthlyIncome;
    private double budgetLimit;

    @Override
    public void setMonthlyIncome(double income) {
        this.monthlyIncome = income;
    }

    @Override
    public void setBudgetLimit(double limit) {
        this.budgetLimit = limit;
    }

    @Override
    public double getRemainingBudget(double currentSpending) {
        return budgetLimit - currentSpending;
    }

    @Override
    public String suggestSavingsPlan(double savingsGoal) {
        double savingsPercentage = (savingsGoal / monthlyIncome) * 100;
        return "To save " + savingsGoal + ", allocate " + savingsPercentage + "% of your monthly income.";
    }

    public String recommendBudgetPlan(List<Transaction> transactions) {
        double totalExpenses = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();

        double remainingBudget = getRemainingBudget(totalExpenses);

        if (remainingBudget < 0) {
            return "You have exceeded your budget by " + Math.abs(remainingBudget) + ". Consider reducing spending.";
        } else {
            return "You have " + remainingBudget + " remaining in your budget.";
        }
    }

    public String generateReportForUser(User user, List<Transaction> transactions) {
        double totalExpenses = transactions.stream().mapToDouble(Transaction::getAmount).sum();

        if (user instanceof PremiumUser) {
            return "Detailed report for Premium User with total expenses: " + totalExpenses;
        } else if (user instanceof BasicUser) {
            return "Basic report for Basic User with total expenses: " + totalExpenses;
        }
        return "Unknown user type.";
    }
}
