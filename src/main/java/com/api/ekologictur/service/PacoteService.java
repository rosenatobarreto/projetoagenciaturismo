package com.api.ekologictur.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.ekologictur.dao.PacoteDao;
import com.api.ekologictur.model.Pacote;

@Service
public class PacoteService {
	
	@Autowired
	private PacoteDao pacoteDao;
	
	public Pacote save(Pacote pacote) {
		return pacoteDao.save(pacote);
	}

	public Pacote deleteById(long id) {
		return null;
	}

	public Optional<Pacote> findById(long id) {
		return pacoteDao.findById((int) id);
	}

	public List<Pacote> findAll() {
		return (List<Pacote>) pacoteDao.findAll();
	}
		
	public Pacote update(long id, Pacote pacote) {
		return pacoteDao.save(pacote);
	}
	
	

}
