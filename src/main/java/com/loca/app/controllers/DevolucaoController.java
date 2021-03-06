package com.loca.app.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loca.app.entity.Devolucao;
import com.loca.app.services.DevolucaoService;
import com.loca.app.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/devolucoes")
public class DevolucaoController {

    @Autowired
    private DevolucaoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Devolucao>> findAll() {
        Collection<Devolucao> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{emprestimoId}/{fitaId}", method = RequestMethod.GET)
    public ResponseEntity<Devolucao> find(@PathVariable Integer emprestimoId, @PathVariable Integer fitaId) {
        Devolucao obj = service.findById(emprestimoId, fitaId);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Devolucao> insert(@Valid @RequestBody Devolucao obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{emprestimoId}/{fitaId}", method = RequestMethod.PUT)
    public ResponseEntity<Devolucao> update(@Valid @RequestBody Devolucao obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{emprestimoId}/{fitaId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer emprestimoId, @PathVariable Integer fitaId) {
        service.delete(emprestimoId, fitaId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/findByClienteAndPeriodo/{idCliente}/{inicio}/{termino}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Devolucao>> findByClienteAndPeriodo(@PathVariable Integer idCliente, @PathVariable String inicio, @PathVariable String termino) {
        Collection<Devolucao> collection = service.findByClienteAndPeriodo(idCliente, inicio, termino);
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/findQuantidadeDevolucaoClienteByPeriodo/{inicio}/{termino}", method = RequestMethod.GET)
    public ResponseEntity<Collection<?>> findQuantidadeDevolucaoClienteByPeriodo(@PathVariable String inicio, @PathVariable String termino) {
        Collection<?> collection = service.findQuantidadeDevolucaoClienteByPeriodo(inicio, termino);
        return ResponseEntity.ok().body(collection);
    }

}