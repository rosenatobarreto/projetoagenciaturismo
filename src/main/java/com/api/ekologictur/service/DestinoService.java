package com.api.ekologictur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.ekologictur.dao.DestinoDao;
import com.api.ekologictur.model.Destino;

@Service
public class DestinoService {
	
	@Autowired
	private DestinoDao destinoDao;
	
	public Destino save(Destino destino) {
		return destinoDao.save(destino);
	}

	public Destino deleteById(long id) {
		return null;
	}

	public Optional<Destino> findById(long id) {
		return Optional.of(destinoDao.findById((int) id).get());
	}

	public List<Destino> findAll() {
		return (List<Destino>) destinoDao.findAll();
	}

	public Destino update(long id, Destino destino) {
		return destinoDao.save(destino);
	}
	
	public List<Destino> findAllByTipoDestino(String tipoDestino, Pageable pageable) {
		return (List<Destino>) destinoDao.findAllByTipoDestino(tipoDestino, pageable);
	}

}
