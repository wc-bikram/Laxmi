package com.Laxmi.financeManager.controller;
import com.Laxmi.financeManager.entity.Transaction;
import com.Laxmi.financeManager.service.AnalyticsService;
import com.Laxmi.financeManager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AnalyticsService analyticsService;

    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/analytics")
    public String getAnalytics(@RequestParam Long userId) {
        // Logic to fetch user and transaction data
        return "User-specific financial report";
    }
}
