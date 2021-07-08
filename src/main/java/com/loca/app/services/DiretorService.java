package com.loca.app.services;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.loca.app.entity.Diretor;
import com.loca.app.repositories.DiretorRepository;
import com.loca.app.services.exceptions.DataIntegrityException;
import com.loca.app.services.exceptions.ObjectNotFoundException;


@Service
public class DiretorService {

    @Autowired
    private DiretorRepository repository;

    public Diretor findById(Integer id) {
        Diretor obj = repository.findById(id).get();
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Diretor.class.getName());
        }
        return obj;
    }

    public Collection<Diretor> findAll() {
        return repository.findAll();
    }

    public Diretor insert(Diretor obj) {
    	obj.setId(null);
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Diretor não foi(foram) preenchido(s)");
        }
    }

    public Diretor update(Diretor obj) {
    	findById(obj.getId());
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Diretor não foi(foram) preenchido(s)");
        }
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um Diretor associado a um Filme!");
        }
    }

}
