package com.loca.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loca.app.entity.Participacao;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Integer> {
	
}