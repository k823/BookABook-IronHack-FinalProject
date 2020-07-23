package com.ironhack.erp.edgeservice.security;

import com.ironhack.erp.edgeservice.model.security.Role;
import com.ironhack.erp.edgeservice.model.security.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class CustomSecurityUserTest {
    private User user;
    private CustomSecurityUser customSecurityUser;

    @BeforeEach
    public void setUp(){
        user = new User("admin", "admin");
        HashSet<Role> roles = new HashSet<Role>();
        Role role = new Role( "admin", new User());
        roles.add(role);
        user.setRoles(roles);

        customSecurityUser = new CustomSecurityUser(user);
    }

    @AfterEach
    public void tearDown(){
        user = null;
        customSecurityUser = null;
    }

    @Test
    public void isAccountNonExpired_customSecurityUser_boolean(){
        assertTrue(customSecurityUser.isAccountNonExpired());
    }

    @Test
    public void setCustomSecurityUser_userRoles_userGerRoles(){
        customSecurityUser.setRoles(user.getRoles());
        assertEquals(user.getRoles(), customSecurityUser.getRoles());
    }

    @Test
    public void isAccountNonLocked_customSecurityUser_boolean(){
        assertTrue(customSecurityUser.isAccountNonLocked());
    }

    @Test
    public void isCredentialsNonExpired_customSecurityUser_boolean(){
        assertTrue(customSecurityUser.isCredentialsNonExpired());
    }

    @Test
    public void isEnabled_CustomSecurityUser_boolean(){
        assertTrue(customSecurityUser.isEnabled());
    }

    @Test
    void getAuthorities() {
        Collection<? extends GrantedAuthority> result = customSecurityUser.getAuthorities();
        assertEquals(1, result.size());
    }
}
