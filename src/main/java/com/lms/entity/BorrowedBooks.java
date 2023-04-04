package com.lms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "borrowed_books")
public class BorrowedBooks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "borrowed_id")
	private int borrowedId;

	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	private Students students;

	@ManyToOne
	@JoinColumn(name = "book_id", referencedColumnName = "book_id")
	private Books books;

	@ManyToOne
	@JoinColumn(name = "librarian_id", referencedColumnName = "librarian_id")
	private Librarians librarians;

	@Column(name = "date_borrowed")
	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	private Date dateBorrowed;

	@Column(name = "due_date")
	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	private Date dueDate;

	@Column(name = "date_returned")
	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	private Date dateReturned;

	@Column(name = "fine_amount")
	private Integer fineAmount;

}
