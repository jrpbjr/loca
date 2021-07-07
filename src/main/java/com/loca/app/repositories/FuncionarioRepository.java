package com.loca.app.repositories;


import org.springframework.transaction.annotation.Transactional;

import com.loca.app.entity.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	@Transactional(readOnly = true)
	public Funcionario findByLoginAndSenha(String login, String senha);

}