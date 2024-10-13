package com.Laxmi.financeManager.service;

import com.Laxmi.financeManager.entity.User;
import com.Laxmi.financeManager.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setName("Bikram Roy");
        testUser.setEmail("bikramroy756@gmail.com");
        testUser.setPassword("password123");
    }

    @Test
    void testSaveUser() {
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        User savedUser = userService.saveUser(testUser);

        assertNotNull(savedUser);
        assertEquals("Bikram Roy", savedUser.getName());
        assertEquals("bikramroy756@gmail.com", savedUser.getEmail());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testFindUserByEmail() {
        when(userRepository.findByEmail("bikramroy756@gmail.com")).thenReturn(Optional.of(testUser));

        User foundUser = userService.findUserByEmail("bikramroy756@gmail.com");

        assertNotNull(foundUser);
        assertEquals("Bikram Roy", foundUser.getName());
        assertEquals("bikramroy756@gmail.com", foundUser.getEmail());
        verify(userRepository, times(1)).findByEmail("bikramroy756@gmail.com");
    }

    @Test
    void testFindUserByEmail_NotFound() {
        when(userRepository.findByEmail("unknown@example.com")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->
                        userService.findUserByEmail("unknown@example.com"),
                "Should throw RuntimeException when user is not found"
        );
        verify(userRepository, times(1)).findByEmail("unknown@example.com");
    }
}