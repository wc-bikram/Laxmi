package com.Laxmi.financeManager.service;

import com.Laxmi.financeManager.entity.User;
import com.Laxmi.financeManager.entity.PremiumUser;
import com.Laxmi.financeManager.entity.BasicUser;
import com.Laxmi.financeManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Save user method that can handle different user types
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Method to find a user by email
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    // New method to find a user by name
    public User findUserByName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("User not found with name: " + name));
    }

    // Method to find a user by ID
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // Example method to create a PremiumUser
    public PremiumUser createPremiumUser(String name, String email, String password, String subscriptionType) {
        PremiumUser premiumUser = new PremiumUser(name, email, password, subscriptionType);
        return (PremiumUser) saveUser(premiumUser);
    }

    // Example method to create a BasicUser
    public BasicUser createBasicUser(String name, String email, String password, boolean limitedAccess) {
        BasicUser basicUser = new BasicUser(name, email, password, limitedAccess);
        return (BasicUser) saveUser(basicUser);
    }

    // Method to update user details
    public User updateUser(Long id, User updatedUser) {
        User existingUser = findUserById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword()); // Consider hashing this before saving
        return userRepository.save(existingUser);
    }

    // Method to delete a user by ID
    public void deleteUser(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }

    // Method to list all users
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Method to check if a user exists by email
    public boolean userExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    // Additional methods for user management can be added here
}