package com.Laxmi.financeManager.repository;
import com.Laxmi.financeManager.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}