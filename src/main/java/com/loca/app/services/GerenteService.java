package com.loca.app.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.loca.app.entity.Gerente;
import com.loca.app.repositories.GerenteRepository;
import com.loca.app.services.exceptions.DataIntegrityException;
import com.loca.app.services.exceptions.ObjectNotFoundException;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository repository;

    public Gerente findById(Integer id) {
    	try {
        	Gerente obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Gerente.class.getName());
        }
    }

    public Collection<Gerente> findAll() {
        return repository.findAll();
    }

    public Gerente insert(Gerente obj) {
        obj.setId(null);
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Gerente não foi(foram) preenchido(s): Bairro");
        }
    }

    public Gerente update(Gerente obj) {
        findById(obj.getId());
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Gerente não foi(foram) preenchido(s): Bairro");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir este Gerente!");
        }
    }

}