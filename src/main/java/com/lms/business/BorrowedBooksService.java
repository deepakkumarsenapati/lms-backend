package com.lms.business;

import java.util.List;

import com.lms.entity.BorrowedBooks;

public interface BorrowedBooksService {
	public BorrowedBooks saveBorrowedBooks(BorrowedBooks borrowBooks);

	public List<BorrowedBooks> getAllBorrowedBooks();

	public BorrowedBooks getBorrowedBooksById(Integer id);

	public BorrowedBooks updateBorrowedBooksById(BorrowedBooks borrowedBooks, Integer id);

	public void deleteBorrowedBooks(Integer id);

}
