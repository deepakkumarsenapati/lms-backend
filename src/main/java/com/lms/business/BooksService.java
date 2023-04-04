package com.lms.business;

import java.util.List;

import com.lms.entity.Books;

public interface BooksService {

	public Books saveBook(Books book);

	public List<Books> getAllBook();

	public Books getBookById(Integer id);

	public Books updateBookById(Books book, Integer id);

	public void deleteBook(Integer id);
}
