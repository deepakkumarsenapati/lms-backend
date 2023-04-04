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

import com.lms.business.LibrariansService;
import com.lms.entity.Librarians;

@RestController
@RequestMapping("/api/librarians")
public class LibrariansController {

	@Autowired
	private LibrariansService librariansService;

	@PostMapping()
	public ResponseEntity<Librarians> saveLibrarians(@RequestBody Librarians librarians) {
		return new ResponseEntity<Librarians>(librariansService.saveLibrarians(librarians), HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<Librarians>> getAllLibrarians() {
		return new ResponseEntity<List<Librarians>>(librariansService.getAllLibrarians(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Librarians> getLibrariansById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Librarians>(librariansService.getLibrariansById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Librarians> updateLibrariansById(@PathVariable("id") Integer id,
			@RequestBody Librarians librarians) {
		return new ResponseEntity<Librarians>(librariansService.updateLibrariansById(librarians, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteLibrariansById(@PathVariable("id") Integer id) {
		librariansService.deleteLibrarians(id);
		return new ResponseEntity<String>("Librarian Deleted Successfully!", HttpStatus.OK);
	}
}
