package com.lms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.Librarians;
import com.lms.exception.ResourceNotFoundException;
import com.lms.repository.LibrariansRepository;

@Service
public class LibrariansServiceImple implements LibrariansService {

	@Autowired
	private LibrariansRepository librariansRepository;

	@Override
	public Librarians saveLibrarians(Librarians librarians) {
		return librariansRepository.save(librarians);
	}

	@Override
	public List<Librarians> getAllLibrarians() {
		return librariansRepository.findAll();
	}

	@Override
	public Librarians getLibrariansById(Integer id) {
		return librariansRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Librarians", "ID", id));
	}

	@Override
	public Librarians updateLibrariansById(Librarians librarians, Integer id) {
		Librarians existingLibrarians = librariansRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Librarians", "ID", id));
		existingLibrarians.setFirstName(librarians.getFirstName());
		existingLibrarians.setLastName(librarians.getLastName());
		existingLibrarians.setLastName(librarians.getLastName());
		existingLibrarians.setEmail(librarians.getEmail());
		existingLibrarians.setPhoneNumber(librarians.getPhoneNumber());
		existingLibrarians.setAddress(librarians.getAddress());
		existingLibrarians.setGender(librarians.getGender());
		existingLibrarians.setDateOfBirth(librarians.getDateOfBirth());

		return librariansRepository.save(existingLibrarians);
	}

	@Override
	public void deleteLibrarians(Integer id) {
		librariansRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Librarians", "ID", id));
		librariansRepository.deleteById(id);

	}

}
