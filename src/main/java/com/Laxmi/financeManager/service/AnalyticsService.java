package com.Laxmi.financeManager.service;

import com.Laxmi.financeManager.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    // Calculate total monthly expenses for the provided list of transactions
    public double calculateMonthlyExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t instanceof ExpenseTransaction)
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    // Calculate total monthly income for the provided list of transactions
    public double calculateMonthlyIncome(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t instanceof IncomeTransaction)
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    // Generate a financial report for the user based on their type
    public String generateReport(User user, List<Transaction> transactions) {
        double totalIncome = calculateMonthlyIncome(transactions);
        double totalExpenses = calculateMonthlyExpenses(transactions);
        double savings = totalIncome - totalExpenses;

        StringBuilder report = new StringBuilder();

        if (user instanceof PremiumUser) {
            report.append("Premium User Report:\n")
                    .append("Total Income: ").append(totalIncome).append("\n")
                    .append("Total Expenses: ").append(totalExpenses).append("\n")
                    .append("Savings: ").append(savings).append("\n")
                    .append("Detailed analytics available for Premium Users.\n");
        } else if (user instanceof BasicUser) {
            report.append("Basic User Report:\n")
                    .append("Total Income: ").append(totalIncome).append("\n")
                    .append("Total Expenses: ").append(totalExpenses).append("\n")
                    .append("Savings: ").append(savings).append("\n")
                    .append("Consider upgrading to Premium for more insights.\n");
        } else {
            return "User type not recognized.";
        }

        return report.toString();
    }

    // Method to generate a report for a specific user
    public String generateReportForUser(Long userId, List<Transaction> transactions) {
        User user = fetchUserById(userId); // Replace with actual method to get the user
        return generateReport(user, transactions); // Pass the transactions parameter correctly
    }

    // Dummy method to represent fetching a user by ID
    private User fetchUserById(Long userId) {
        // This method should access the database to retrieve the User object based on userId
        // For now, return a dummy user for demonstration
        return new BasicUser(); // Replace with actual user retrieval logic
    }
}
