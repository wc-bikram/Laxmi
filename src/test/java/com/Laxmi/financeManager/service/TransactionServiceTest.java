package com.Laxmi.financeManager.service;
import com.Laxmi.financeManager.entity.Transaction;
import com.Laxmi.financeManager.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")  // Ensure it runs under the test profile
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    public void testSaveTransaction() {
        Transaction transaction = new Transaction() {
            @Override
            public void execute() {

            }
        };
        transaction.setAmount(500);
        transaction.setDescription("Test Transaction");

        when(transactionRepository.save(transaction)).thenReturn(transaction);

        Transaction savedTransaction = transactionService.saveTransaction(transaction);

        assertEquals(500, savedTransaction.getAmount());
        assertEquals("Test Transaction", savedTransaction.getDescription());

        verify(transactionRepository, times(1)).save(transaction);
    }
}