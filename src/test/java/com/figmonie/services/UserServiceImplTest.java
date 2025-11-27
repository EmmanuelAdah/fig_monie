package com.figmonie.services;

import com.figmonie.data.models.User;
import com.figmonie.dtos.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    void testThat_canSaveValidUser() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstname("Emma");
        request.setLastname("Adah");
        request.setEmail("edo@gmail.com");
        request.setPassword("12345");

        User response = userService.saveUser(request);
        assertNotNull(response);
    }

    @Test
    void findByUsername() {
    }
}