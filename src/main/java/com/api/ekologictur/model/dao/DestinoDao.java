package com.api.ekologictur.model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.api.ekologictur.model.Destino;

@Repository
public interface DestinoDao extends PagingAndSortingRepository<Destino, Integer>{

}
