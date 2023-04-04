package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.business.BooksService;
import com.lms.entity.Books;

@RestController
@RequestMapping("/api/books")
public class BooksController {

	@Autowired
	private BooksService booksService;

	@PostMapping()
	public ResponseEntity<Books> saveBook(@RequestBody Books book) {
		return new ResponseEntity<Books>(booksService.saveBook(book), HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<Books>> getAllBooks() {
		return new ResponseEntity<List<Books>>(booksService.getAllBook(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Books> getBookById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Books>(booksService.getBookById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Books> updateBookById(@PathVariable("id") Integer id, @RequestBody Books book) {
		return new ResponseEntity<Books>(booksService.updateBookById(book, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable("id") Integer id) {
		booksService.deleteBook(id);
		return new ResponseEntity<String>("Book Deleted Successfully!", HttpStatus.OK);
	}

}
