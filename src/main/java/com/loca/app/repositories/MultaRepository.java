package com.loca.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loca.app.entity.Multa;
import com.loca.app.entity.MultaPK;



@Repository
public interface MultaRepository extends JpaRepository<Multa, MultaPK> {
	
}
