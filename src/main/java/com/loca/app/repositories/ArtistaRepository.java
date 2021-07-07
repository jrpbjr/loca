package com.loca.app.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loca.app.entity.Artista;


@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {

    @Transactional(readOnly = true)
    public Collection<Artista> findAllByOrderByNome();

    @Transactional(readOnly = true)
    public Collection<Artista> findByNome(String nome);

}
