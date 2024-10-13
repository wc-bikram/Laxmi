package com.Laxmi.financeManager.report;

public abstract class Report {
    protected String userName;
    protected double totalIncome;
    protected double totalExpenses;
    protected double savings;

    public Report(String userName, double totalIncome, double totalExpenses) {
        this.userName = userName;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.savings = totalIncome - totalExpenses;
    }

    // Abstract method for generating a report
    public abstract String generateReport();
}