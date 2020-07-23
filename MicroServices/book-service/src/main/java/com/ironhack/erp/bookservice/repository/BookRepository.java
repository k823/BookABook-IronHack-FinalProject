package com.ironhack.erp.bookservice.repository;

import com.ironhack.erp.bookservice.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
