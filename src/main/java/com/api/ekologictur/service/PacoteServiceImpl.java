package com.api.ekologictur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ekologictur.model.Pacote;
import com.api.ekologictur.repositories.PacoteRepository;

@Service
public class PacoteServiceImpl {//implements PacoteService {
	
	@Autowired
	private PacoteRepository pacoteRepository;
	
	public Pacote save(Pacote pacote) {
		return pacoteRepository.save(pacote);
	}

	public Pacote deleteById(long id) {
		return null;
	}

	public Optional<Pacote> findById(long id) {
		return Optional.of(pacoteRepository.findById(id).get());
	}

	public List<Pacote> findAll() {
		return pacoteRepository.findAll();
	}

	public Pacote update(long id, Pacote pacote) {
		return pacoteRepository.save(pacote);
	}

}
