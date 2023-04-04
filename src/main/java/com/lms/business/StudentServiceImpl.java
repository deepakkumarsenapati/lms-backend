package com.lms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.Students;
import com.lms.exception.ResourceNotFoundException;
import com.lms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Students saveStudent(Students student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Students> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Students getStudentsById(Integer id) {
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
	}

	@Override
	public Students updateStudentById(Students student, Integer id) {
		Students existingStudents = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
		existingStudents.setFirstName(student.getFirstName());
		existingStudents.setLastName(student.getLastName());
		existingStudents.setLastName(student.getLastName());
		existingStudents.setEmail(student.getEmail());
		existingStudents.setPhoneNumber(student.getPhoneNumber());
		existingStudents.setAddress(student.getAddress());
		existingStudents.setGender(student.getGender());
		existingStudents.setDateOfBirth(student.getDateOfBirth());

		return studentRepository.save(existingStudents);
	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "ID", id));
		studentRepository.deleteById(id);
	}

}
