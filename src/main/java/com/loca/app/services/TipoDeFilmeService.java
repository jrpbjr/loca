package com.loca.app.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.loca.app.entity.TipoDeFilme;
import com.loca.app.repositories.TipoDeFilmeRepository;
import com.loca.app.services.exceptions.DataIntegrityException;
import com.loca.app.services.exceptions.ObjectNotFoundException;

@Service
public class TipoDeFilmeService {

    @Autowired
    private TipoDeFilmeRepository repository;

    public TipoDeFilme findById(Integer id) {
    	try {
        	TipoDeFilme obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + TipoDeFilme.class.getName());
        }
    }

    public Collection<TipoDeFilme> findAll() {
        return repository.findAll();
    }

//    public TipoDeFilme insert(TipoDeFilme obj) {
//        obj.setId(null);
//        try {
//        	return repository.save(obj);
//        } catch (DataIntegrityViolationException e) {
//            throw new DataIntegrityException("Campo(s) obrigatório(s) do Tipo de Filme não foi(foram) preenchido(s)");
//        }
//    }
//
//    public TipoDeFilme update(TipoDeFilme obj) {
//        findById(obj.getId());
//        try {
//        	return repository.save(obj);
//        } catch (DataIntegrityViolationException e) {
//            throw new DataIntegrityException("Campo(s) obrigatório(s) do Tipo de Filme não foi(foram) preenchido(s)");
//        }
//    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um Tipo de Filme com Filmes vinculados a Empréstimos!");
        }
    }

    public Collection<TipoDeFilme> findMaioresPrecos(Double preco) {
        return repository.findMaioresPrecos(preco);
    }

}