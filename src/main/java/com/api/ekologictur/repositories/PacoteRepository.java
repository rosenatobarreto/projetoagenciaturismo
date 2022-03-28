package com.api.ekologictur.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ekologictur.model.Pacote;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long> {

}
