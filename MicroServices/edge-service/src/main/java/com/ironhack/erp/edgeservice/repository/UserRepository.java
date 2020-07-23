package com.ironhack.erp.edgeservice.repository;

import com.ironhack.erp.edgeservice.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   public User findByUsername(String username);
}
