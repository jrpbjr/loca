package com.loca.app.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loca.app.entity.Filme;
import com.loca.app.entity.TipoDeFilme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    @Transactional(readOnly = true)
    public Collection<Filme> findByTipoDeFilme(TipoDeFilme tipoDeFilme);
    	
}