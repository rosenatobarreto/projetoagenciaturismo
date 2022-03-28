package com.api.ekologictur.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.api.ekologictur.model.Destino;

//@Repository
public interface DestinoDao extends PagingAndSortingRepository<Destino, Integer>{
	//Page<Destino> findAllByTipoDestino(String tipoDestino, Pageable pageable);
}
