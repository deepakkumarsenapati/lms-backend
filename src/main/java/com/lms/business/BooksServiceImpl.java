package com.lms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.Books;
import com.lms.exception.ResourceNotFoundException;
import com.lms.repository.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksRepository booksRepository;

	@Override
	public Books saveBook(Books book) {
		return booksRepository.save(book);
	}

	@Override
	public List<Books> getAllBook() {
		return booksRepository.findAll();
	}

	@Override
	public Books getBookById(Integer id) {
		return booksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Books", "ID", id));
	}

	@Override
	public Books updateBookById(Books book, Integer id) {
		Books existingBook = booksRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Books", "ID", id));
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setCategory(book.getCategory());
		existingBook.setAvailableCopies(book.getAvailableCopies());
		existingBook.setTotalCopies(book.getTotalCopies());
		return booksRepository.save(existingBook);
	}

	@Override
	public void deleteBook(Integer id) {
		booksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Books", "ID", id));
		booksRepository.deleteById(id);
	}

}
