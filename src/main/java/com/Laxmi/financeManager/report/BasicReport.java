package com.Laxmi.financeManager.report;

public class BasicReport extends Report {

    public BasicReport(String userName, double totalIncome, double totalExpenses) {
        super(userName, totalIncome, totalExpenses);
    }

    @Override
    public String generateReport() {
        return "Basic Report for " + userName + "\n" +
                "Total Income: $" + totalIncome + "\n" +
                "Total Expenses: $" + totalExpenses + "\n" +
                "Savings: $" + savings + "\n";
    }
}