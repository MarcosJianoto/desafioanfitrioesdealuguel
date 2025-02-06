package com.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.entities.Acomodacoes;

public interface AcomodacoesRepository extends JpaRepository<Acomodacoes, Long> {

	List<Acomodacoes> findByCityIgnoreCase(String city);

}
