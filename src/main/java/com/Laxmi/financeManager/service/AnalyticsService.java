package com.Laxmi.financeManager.service;
import com.Laxmi.financeManager.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {
    public double calculateMonthlyExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t instanceof ExpenseTransaction)
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double calculateMonthlyIncome(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t instanceof IncomeTransaction)
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public String generateReport(User user, List<Transaction> transactions) {
        if (user instanceof PremiumUser) {
            // Provide advanced insights for PremiumUser
            return "Detailed report with analytics...";
        } else if (user instanceof BasicUser) {
            // Provide basic insights for BasicUser
            return "Basic financial report...";
        }
        return "User type not recognized.";
    }
}
