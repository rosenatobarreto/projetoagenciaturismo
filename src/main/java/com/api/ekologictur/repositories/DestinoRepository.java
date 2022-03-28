package com.api.ekologictur.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ekologictur.model.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {

}
