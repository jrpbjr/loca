package com.loca.app.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.loca.app.entity.Funcionario;
import com.loca.app.repositories.FuncionarioRepository;
import com.loca.app.services.exceptions.DataIntegrityException;
import com.loca.app.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario findById(Integer id) {
    	try {
        	Funcionario obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName());
        }
    }

    public Collection<Funcionario> findAll() {
        return repository.findAll();
    }

//    public Funcionario insert(Funcionario obj) {
//    	obj.setId(null);
//        try {
//        	return repository.save(obj);
//        } catch (DataIntegrityViolationException e) {
//            throw new DataIntegrityException("Campo(s) obrigatório(s) do Funcionário não foi(foram) preenchido(s): Bairro");
//        }
//    }
//
//    public Funcionario update(Funcionario obj) {
//        findById(obj.getId());
//        try {
//        	return repository.save(obj);
//        } catch (DataIntegrityViolationException e) {
//            throw new DataIntegrityException("Campo(s) obrigatório(s) do Funcionário não foi(foram) preenchido(s): Bairro");
//        }
//    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir este Funcionário!");
        }
    }

    public Funcionario findByLoginAndSenha(String login, String senha) {
        return repository.findByLoginAndSenha(login, senha);
    }
    
}