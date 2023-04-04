package com.lms.business;

import java.util.List;

import com.lms.entity.Students;

public interface StudentService {
	public Students saveStudent(Students student);

	public List<Students> getAllStudent();

	public Students getStudentsById(Integer id);

	public Students updateStudentById(Students student, Integer id);

	public void deleteStudent(Integer id);

}
