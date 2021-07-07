package com.loca.app.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loca.app.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
    @Transactional(readOnly = true)
    @Query(value = "SELECT CLIENTE.*  FROM EMPRESTIMO INNER JOIN CLIENTE ON EMPRESTIMO.CLIENTE_ID = CLIENTE.ID INNER JOIN MULTA ON EMPRESTIMO.ID = MULTA.EMPRESTIMO_ID WHERE MULTA.PAGO = 'FALSE'", nativeQuery = true)
    public Collection<Cliente> findDevedores();
    
}