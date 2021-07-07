package com.loca.app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loca.app.entity.Diretor;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Integer> {
	
}
