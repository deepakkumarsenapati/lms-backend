package com.lms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.BorrowedBooks;
import com.lms.exception.ResourceNotFoundException;
import com.lms.repository.BorrowedBooksRespository;

@Service
public class BorrowedBooksServiceImpl implements BorrowedBooksService {

	@Autowired
	private BorrowedBooksRespository borrowedBooksRespository;

	@Override
	public BorrowedBooks saveBorrowedBooks(BorrowedBooks borrowBooks) {
		return borrowedBooksRespository.save(borrowBooks);
	}

	@Override
	public List<BorrowedBooks> getAllBorrowedBooks() {
		return borrowedBooksRespository.findAll();
	}

	@Override
	public BorrowedBooks getBorrowedBooksById(Integer id) {
		return borrowedBooksRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("BorrowedBooks", "ID", id));
	}

	@Override
	public BorrowedBooks updateBorrowedBooksById(BorrowedBooks borrowedBooks, Integer id) {
		BorrowedBooks existingBorrowedBooks = borrowedBooksRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("BorrowedBooks", "ID", id));
		existingBorrowedBooks.setStudents(borrowedBooks.getStudents());
		existingBorrowedBooks.setBooks(borrowedBooks.getBooks());
		existingBorrowedBooks.setLibrarians(borrowedBooks.getLibrarians());
		existingBorrowedBooks.setDateBorrowed(borrowedBooks.getDateBorrowed());
		existingBorrowedBooks.setDueDate(borrowedBooks.getDueDate());
		existingBorrowedBooks.setDateReturned(borrowedBooks.getDateReturned());
		existingBorrowedBooks.setFineAmount(borrowedBooks.getFineAmount());
		return borrowedBooksRespository.save(existingBorrowedBooks);
	}

	@Override
	public void deleteBorrowedBooks(Integer id) {
		borrowedBooksRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("BorrowedBooks", "ID", id));
		borrowedBooksRespository.deleteById(id);
		;
	}

}
