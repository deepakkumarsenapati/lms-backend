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

import com.lms.business.StudentService;
import com.lms.entity.Students;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping()
	public ResponseEntity<Students> saveEmployee(@RequestBody Students student) {
		return new ResponseEntity<Students>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<Students>> getAllStudents() {
		return new ResponseEntity<List<Students>>(studentService.getAllStudent(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Students> getStudentById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Students>(studentService.getStudentsById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Students> updateStudentById(@PathVariable("id") Integer id, @RequestBody Students student) {
		return new ResponseEntity<Students>(studentService.updateStudentById(student, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudentsById(@PathVariable("id") Integer id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student Deleted Successfully!", HttpStatus.OK);
	}

}
