package com.loca.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loca.app.entity.ItemDeEmprestimo;
import com.loca.app.entity.ItemDeEmprestimoPK;

@Repository
public interface ItemDeEmprestimoRepository extends JpaRepository<ItemDeEmprestimo, ItemDeEmprestimoPK> {
	
}
