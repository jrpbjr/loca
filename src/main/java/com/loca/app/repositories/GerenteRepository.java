package com.loca.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loca.app.entity.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer> {

}