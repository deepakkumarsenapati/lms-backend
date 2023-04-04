package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.BorrowedBooks;

public interface BorrowedBooksRespository extends JpaRepository<BorrowedBooks, Integer>{

}
