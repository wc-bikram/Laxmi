package com.Laxmi.financeManager.controller;

import com.Laxmi.financeManager.dto.TransactionDTO; // Import the DTO
import com.Laxmi.financeManager.entity.Transaction;
import com.Laxmi.financeManager.service.AnalyticsService;
import com.Laxmi.financeManager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AnalyticsService analyticsService;

    // Add a new transaction
    @PostMapping("/add")
    public ResponseEntity<TransactionDTO> addTransaction(@RequestBody TransactionDTO transactionDTO) {
        // Convert DTO to entity
        Transaction transaction = new Transaction() {
            @Override
            public void execute() {

            }
        };
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setDescription(transactionDTO.getDescription());

        // Save the transaction using the service
        Transaction savedTransaction = transactionService.saveTransaction(transaction);

        // Convert saved entity back to DTO for response
        TransactionDTO responseDTO = new TransactionDTO(savedTransaction.getAmount(), savedTransaction.getDescription());
        return ResponseEntity.ok(responseDTO);
    }

    // Get all transactions
    @GetMapping("/all")
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();

        // Convert all transactions to DTOs
        List<TransactionDTO> transactionDTOs = transactions.stream()
                .map(transaction -> new TransactionDTO(transaction.getAmount(), transaction.getDescription()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(transactionDTOs);
    }

    // Get user-specific analytics
    @GetMapping("/analytics/{userId}")
    public ResponseEntity<String> getAnalytics(@PathVariable Long userId) {
        // Fetch user analytics using the analyticsService
        List<Transaction> transactions = transactionService.findTransactionsByUserId(userId); // Get transactions for user
        String analyticsReport = analyticsService.generateReportForUser(userId, transactions); // Generate report
        return ResponseEntity.ok(analyticsReport);
    }
}
