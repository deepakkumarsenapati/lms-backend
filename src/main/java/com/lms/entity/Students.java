package com.lms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class Students {

	@Id
	@Column(name = "student_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "date_of_birth", nullable = false)
	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	private Date dateOfBirth;

//	@OneToOne(mappedBy = "students")
//	private BorrowedBooks borrowedBooks;

}
