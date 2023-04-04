package com.lms.business;

import java.util.List;

import com.lms.entity.Librarians;

public interface LibrariansService {

	public Librarians saveLibrarians(Librarians librarians);

	public List<Librarians> getAllLibrarians();

	public Librarians getLibrariansById(Integer id);

	public Librarians updateLibrariansById(Librarians librarians, Integer id);

	public void deleteLibrarians(Integer id);

}
