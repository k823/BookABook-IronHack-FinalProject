package com.ironhack.erp.edgeservice.model.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User(null, null);
    }

    @Test
    void getId() {
        user.setId((long) 1);
        assertEquals(1, user.getId());
    }

    @Test
    void getUsername() {
        user.setUsername("name");
        assertEquals("name", user.getUsername());
    }

    @Test
    void getPassword() {
        user.setPassword("password");
        assertEquals("password", user.getPassword());
    }

    @Test
    void getRoles() {
        user.setRoles(null);
        assertEquals(null, user.getRoles());
    }

    @Test
    void testToString() {
        assertEquals(user.toString(), user.toString());
    }
}