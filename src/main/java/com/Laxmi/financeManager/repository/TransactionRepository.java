package com.Laxmi.financeManager.repository;
import com.Laxmi.financeManager.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Custom query methods can be added here
}