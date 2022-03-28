package com.api.ekologictur.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.api.ekologictur.model.Pacote;

@Service
public interface PacoteService {

	Pacote save(Pacote pacote);
	Pacote deleteById(long id);
	Optional<Pacote> findById(long id);
	List<Pacote> findAll();
	Pacote update(long id, Pacote pacote);

}
