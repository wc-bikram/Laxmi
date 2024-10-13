package com.Laxmi.financeManager.controller;
import com.Laxmi.financeManager.report.*;
import com.Laxmi.financeManager.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/generate")
    public String generateReport(@RequestParam String userName, @RequestParam double totalIncome, @RequestParam double totalExpenses, @RequestParam boolean isPremium) {
        Report report;

        // Generate report based on user type
        if (isPremium) {
            report = new PremiumReport(userName, totalIncome, totalExpenses, "Consider investing in mutual funds.");
        } else {
            report = new BasicReport(userName, totalIncome, totalExpenses);
        }

        String generatedReport = report.generateReport();

        // Send the generated report via email
        notificationService.sendEmail("user@example.com", "Your Financial Report", generatedReport);

        return generatedReport;
    }
}