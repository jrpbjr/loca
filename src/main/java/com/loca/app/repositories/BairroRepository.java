package com.loca.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loca.app.entity.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer> {

}
