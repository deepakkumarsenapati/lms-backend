package com.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "books")
public class Books {

	@Id
	@Column(name = "book_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "author", nullable = false)
	private String author;

	@Column(name = "category", nullable = false)
	private String category;

	@Column(name = "total_copies", nullable = false)
	private Integer totalCopies;

	@Column(name = "available_copies", nullable = false)
	private Integer availableCopies;

//	@OneToOne(mappedBy = "books")
//	private BorrowedBooks borrowedBooks;
}
