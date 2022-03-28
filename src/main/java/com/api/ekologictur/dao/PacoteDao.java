package com.api.ekologictur.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.api.ekologictur.model.Pacote;

//@Repository
public interface PacoteDao extends PagingAndSortingRepository<Pacote, Integer>, JpaRepository<Pacote, Integer>{

	//Page<Pacote> findAllByPriceLessThan(double price, Pageable pageable);
}
