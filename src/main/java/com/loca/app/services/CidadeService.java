package com.loca.app.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.loca.app.entity.Cidade;
import com.loca.app.entity.UF;
import com.loca.app.repositories.CidadeRepository;
import com.loca.app.services.exceptions.DataIntegrityException;
import com.loca.app.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public Cidade findById(Integer id) {
    	try {
        	Cidade obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName());
        }
    }

    public Cidade insert(Cidade obj) {
        obj.setId(null);
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Cidade não foi(foram) preenchido(s): UF");
        }
    }

    public Cidade update(Cidade obj) {
    	findById(obj.getId());
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Cidade não foi(foram) preenchido(s): UF");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma Cidade que possui Bairros!");
        }
    }

    public Collection<Cidade> findAll() {
        return repository.findAll();
    }

    public Collection<Cidade> findByUf(UF uf) {
        return repository.findByUf(uf);
    }

}