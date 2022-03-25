package com.api.ekologictur.model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.api.ekologictur.model.Pacote;

@Repository
public interface PacoteDao extends PagingAndSortingRepository<Pacote, Integer>{

}
