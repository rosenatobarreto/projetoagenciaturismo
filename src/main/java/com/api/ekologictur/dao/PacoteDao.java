package com.api.ekologictur.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.api.ekologictur.model.Pacote;

@Repository
public interface PacoteDao extends PagingAndSortingRepository<Pacote, Integer>{

	//Page<Pacote> findAllByName(String name, Pageable pageable);

	
}
