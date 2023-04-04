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

import com.lms.business.BorrowedBooksService;
import com.lms.entity.BorrowedBooks;

@RestController
@RequestMapping("/api/borrowedbooks")
public class BorrowedBooksController {

	@Autowired
	private BorrowedBooksService borrowedBooksService;

	@PostMapping()
	public ResponseEntity<BorrowedBooks> saveBorrowedBooks(@RequestBody BorrowedBooks borrowedBooks) {
		return new ResponseEntity<BorrowedBooks>(borrowedBooksService.saveBorrowedBooks(borrowedBooks),
				HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<BorrowedBooks>> getAllBorrowedBooks() {
		return new ResponseEntity<List<BorrowedBooks>>(borrowedBooksService.getAllBorrowedBooks(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<BorrowedBooks> getBorrowedBooksById(@PathVariable("id") Integer id) {
		return new ResponseEntity<BorrowedBooks>(borrowedBooksService.getBorrowedBooksById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<BorrowedBooks> updateBorrowedBooksById(@PathVariable("id") Integer id,
			@RequestBody BorrowedBooks borrowedBooks) {
		return new ResponseEntity<BorrowedBooks>(borrowedBooksService.updateBorrowedBooksById(borrowedBooks, id),
				HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBorrowedBooksById(@PathVariable("id") Integer id) {
		borrowedBooksService.deleteBorrowedBooks(id);
		return new ResponseEntity<String>("One Record Deleted Successfully!", HttpStatus.OK);
	}

}
