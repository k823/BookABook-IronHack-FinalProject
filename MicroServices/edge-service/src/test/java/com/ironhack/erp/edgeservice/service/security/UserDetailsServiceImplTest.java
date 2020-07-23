package com.ironhack.erp.edgeservice.service.security;

import com.ironhack.erp.edgeservice.model.security.Role;
import com.ironhack.erp.edgeservice.model.security.User;
import com.ironhack.erp.edgeservice.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserDetailsServiceImplTest {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserRepository userRepo;

    public User user1;
    public Role role1;

    @BeforeEach
    void setUp() {
        user1 = new User("User1", "bananas");
        userRepo.save(user1);
        role1 = new Role("admin", new User());
        role1.setUser(user1);
    }

    @AfterEach
    void tearDown() {
        userRepo.deleteAll();
    }

    @Test
    void loadUserByUsername() {
        UserDetails user = userDetailsService.loadUserByUsername(user1.getUsername());
        assertNotNull(user);
    }

    @Test
    void loadUserByUsernameException() {
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("something"));
    }
}