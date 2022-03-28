package com.api.ekologictur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ekologictur.model.Destino;
import com.api.ekologictur.repositories.DestinoRepository;

@Service
public class DestinoServiceImpl {// implements DestinoService{
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	public Destino save(Destino destino) {
		return destinoRepository.save(destino);
	}

	public Destino deleteById(long id) {
		return null;
	}

	public Optional<Destino> findById(long id) {
		return Optional.of(destinoRepository.findById(id).get());
	}

	public List<Destino> findAll() {
		return destinoRepository.findAll();
	}

	public Destino update(long id, Destino destino) {
		return destinoRepository.save(destino);
	}

}
