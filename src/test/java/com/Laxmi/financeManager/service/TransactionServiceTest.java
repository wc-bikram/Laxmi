package com.Laxmi.financeManager.service;

import com.Laxmi.financeManager.entity.ExpenseTransaction;
import com.Laxmi.financeManager.entity.IncomeTransaction;
import com.Laxmi.financeManager.entity.Transaction;
import com.Laxmi.financeManager.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")  // Ensure it runs under the test profile
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @MockBean
    private TransactionRepository transactionRepository;

    // Test for saving a transaction
    @Test
    public void testSaveTransaction() {
        IncomeTransaction incomeTransaction = new IncomeTransaction();
        incomeTransaction.setAmount(1000);
        incomeTransaction.setDescription("Salary");

        when(transactionRepository.save(incomeTransaction)).thenReturn(incomeTransaction);

        Transaction savedTransaction = transactionService.saveTransaction(incomeTransaction);

        assertEquals(1000, savedTransaction.getAmount());
        assertEquals("Salary", savedTransaction.getDescription());

        verify(transactionRepository, times(1)).save(incomeTransaction);
    }

    // Test for getting all transactions
    @Test
    public void testGetAllTransactions() {
        ExpenseTransaction expenseTransaction = new ExpenseTransaction();
        expenseTransaction.setAmount(200);
        expenseTransaction.setDescription("Groceries");

        IncomeTransaction incomeTransaction = new IncomeTransaction();
        incomeTransaction.setAmount(1500);
        incomeTransaction.setDescription("Freelance Work");

        List<Transaction> transactionList = Arrays.asList(expenseTransaction, incomeTransaction);

        when(transactionRepository.findAll()).thenReturn(transactionList);

        List<Transaction> retrievedTransactions = transactionService.getAllTransactions();

        assertEquals(2, retrievedTransactions.size());
        assertEquals(200, retrievedTransactions.get(0).getAmount());
        assertEquals("Groceries", retrievedTransactions.get(0).getDescription());

        assertEquals(1500, retrievedTransactions.get(1).getAmount());
        assertEquals("Freelance Work", retrievedTransactions.get(1).getDescription());

        verify(transactionRepository, times(1)).findAll();
    }

    // Additional tests for update, delete, or specific transaction retrieval can be added here.
}
