package com.ironhack.erp.edgeservice.model.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleTest {

    Role role;

    @BeforeEach
    void setUp() {
        role = new Role(null, null);
    }

    @Test
    void getId() {
        role.setId((long) 1);
        assertEquals(1, role.getId());
    }

    @Test
    void getRole() {
        role.setRole("role");
        assertEquals("role", role.getRole());
    }

    @Test
    void getUser() {
        role.setUser(new User());
        assertEquals(new User().getId(), role.getUser().getId());
    }

    @Test
    void testToString() {
        assertEquals(role.toString(), role.toString());
    }
}