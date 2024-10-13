package com.Laxmi.financeManager.report;

public class PremiumReport extends Report {

    private String investmentTips;

    public PremiumReport(String userName, double totalIncome, double totalExpenses, String investmentTips) {
        super(userName, totalIncome, totalExpenses);
        this.investmentTips = investmentTips;
    }

    @Override
    public String generateReport() {
        return "Premium Report for " + userName + "\n" +
                "Total Income: $" + totalIncome + "\n" +
                "Total Expenses: $" + totalExpenses + "\n" +
                "Savings: $" + savings + "\n" +
                "Investment Tips: " + investmentTips + "\n";
    }
}
