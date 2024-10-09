package com.Laxmi.financeManager.service;
import com.Laxmi.financeManager.entity.User;
import com.Laxmi.financeManager.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {


    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    public void setUp() {
        testUser = new User();
        testUser.setName("Bikram Roy");
        testUser.setEmail("bikramroy756@gmail.com");
        testUser.setPassword("password123");
    }

    @Test
    public void testSaveUser() {
        when(userRepository.save(testUser)).thenReturn(testUser);

        User savedUser = userService.saveUser(testUser);

        assertEquals("Bikram Roy", savedUser.getName());
        assertEquals("bikramroy756@gmail.com", savedUser.getEmail());
        verify(userRepository, times(1)).save(testUser);
    }

    @Test
    public void testFindUserByEmail() {
        when(userRepository.findByEmail("bikramroy756@gmail.com")).thenReturn(Optional.of(testUser));

        User foundUser = userService.findUserByEmail("bikramroy756@gmail.com");

        assertEquals("Bikram Roy", foundUser.getName());
        assertEquals("bikramroy756@gmail.com", foundUser.getEmail());
        verify(userRepository, times(1)).findByEmail("bikramroy756@gmail.com");
    }

    @Test
    public void testFindUserByEmail_NotFound() {
        when(userRepository.findByEmail("unknown@example.com")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.findUserByEmail("unknown@example.com");
        });

        String expectedMessage = "User not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
