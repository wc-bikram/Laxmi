package com.Laxmi.financeManager.repository;

import com.Laxmi.financeManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Method to find a user by their email address
    Optional<User> findByEmail(String email);

    // Remove the findByUsername method as there's no 'username' field in the User entity
    // Optional<User> findByUsername(String username);

    // If you want to find a user by their name, you can add this method:
    Optional<User> findByName(String name);
}