package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> {

}
