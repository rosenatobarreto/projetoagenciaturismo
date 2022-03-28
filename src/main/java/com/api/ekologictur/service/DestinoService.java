package com.api.ekologictur.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.api.ekologictur.model.Destino;

@Service
public interface DestinoService {
	
	Destino save(Destino destino);
	Destino deleteById(long id);
	Optional<Destino> findById(long id);
	List<Destino> findAll();
	Destino update(long id, Destino destino);
}
