package com.Laxmi.financeManager.controller;
import com.Laxmi.financeManager.budget.AIRecommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private AIRecommender aiRecommender;

    @GetMapping("/suggestSavings")
    public ResponseEntity<String> suggestSavings(@RequestParam double savingsGoal) {
        String suggestion = aiRecommender.suggestSavingsPlan(savingsGoal);
        return ResponseEntity.ok(suggestion);
    }

    @GetMapping("/userReport")
    public ResponseEntity<String> generateUserReport(@RequestParam Long userId) {
        // Logic to fetch user and transaction data, then call AIRecommender
        // Assume user and transaction data are fetched elsewhere
        String report = aiRecommender.generateReportForUser(null, null); // Replace null with actual data
        return ResponseEntity.ok(report);
    }
}