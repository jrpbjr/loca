package com.loca.app.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.loca.app.entity.UF;
import com.loca.app.repositories.UFRepository;
import com.loca.app.services.exceptions.DataIntegrityException;
import com.loca.app.services.exceptions.ObjectNotFoundException;

@Service
public class UFService {

    @Autowired
    private UFRepository repository;

    public UF findById(Integer id) {
    	try {
        	UF obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + UF.class.getName());
        }
    }

    public Collection<UF> findAll() {
        return repository.findAll();
    }

//    public UF insert(UF obj) {
//    	obj.setId(null);
//    	try {
//        	return repository.save(obj);
//        } catch (DataIntegrityViolationException e) {
//            throw new DataIntegrityException("Campo(s) obrigatório(s) da UF não foi(foram) preenchido(s)");
//        }
//    }
//
//    public UF update(UF obj) {
//    	findById(obj.getId());
//    	try {
//        	return repository.save(obj);
//        } catch (DataIntegrityViolationException e) {
//            throw new DataIntegrityException("Campo(s) obrigatório(s) da UF não foi(foram) preenchido(s)");
//        }
//    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma UF que possui cidades!");
        }
    }

}
