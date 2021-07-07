package com.loca.app.services;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.loca.app.entity.Devolucao;
import com.loca.app.entity.DevolucaoPK;
import com.loca.app.entity.Emprestimo;
import com.loca.app.entity.Fita;
import com.loca.app.entity.ItemDeEmprestimo;
import com.loca.app.repositories.DevolucaoRepository;
import com.loca.app.repositories.EmprestimoRepository;
import com.loca.app.repositories.FitaRepository;
import com.loca.app.repositories.ItemDeEmprestimoRepository;
import com.loca.app.services.exceptions.DataIntegrityException;
import com.loca.app.services.exceptions.ObjectNotFoundException;

@Service
public class DevolucaoService {

    @Autowired
    private DevolucaoRepository devolucaoRepository;
    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private FitaRepository fitaRepository;
    @Autowired
    private ItemDeEmprestimoRepository itemDeEmprestimoRepository;

//    public Devolucao findById(Integer idEmprestimo, Integer idFita) {
//        Emprestimo emprestimo = new Emprestimo();
//        Fita fita = new Fita();
//        ItemDeEmprestimo itemDeEmprestimo = new ItemDeEmprestimo();
//        DevolucaoPK id = new DevolucaoPK();
//
//        emprestimo = emprestimoRepository.findById(idEmprestimo).get();
//        fita = fitaRepository.findById(idFita).get();
//        itemDeEmprestimo.getId().setEmprestimo(emprestimo);
//        itemDeEmprestimo.getId().setFita(fita);
//        itemDeEmprestimo = itemDeEmprestimoRepository.findById(itemDeEmprestimo.getId()).get();
//        id.setItemDeEmprestimo(itemDeEmprestimo);
//
//        try {
//        	Devolucao obj = devolucaoRepository.findById(id).get();
//        	return obj;
//        } catch (NoSuchElementException e) {
//        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Devolucao.class.getName());
//        }
//    }

    public Devolucao findById(DevolucaoPK id) {
        Devolucao obj = devolucaoRepository.findById(id).get();
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Devolucao.class.getName());
        }
        return obj;
    }

    public Collection<Devolucao> findAll() {
        return devolucaoRepository.findAll();
    }

    public Devolucao insert(Devolucao obj) {
        try {
        	return devolucaoRepository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Devolução não foi(foram) preenchido(s): Item de Empréstimo (Empréstimo e/ou Fita)");
        }
    }

//    public Devolucao update(Devolucao obj) {
//    	findById(obj.getId());
//        try {
//        	return devolucaoRepository.save(obj);
//        } catch (DataIntegrityViolationException e) {
//            throw new DataIntegrityException("Campo(s) obrigatório(s) da Devolução não foi(foram) preenchido(s): Item de Empréstimo (Empréstimo e/ou Fita)");
//        }
//    }

//    public void delete(Integer idEmprestimo, Integer idFita) {
//        Devolucao devolucao = findById(idEmprestimo, idFita);
//        try {
//            devolucaoRepository.deleteById(devolucao.getId());
//        } catch (DataIntegrityViolationException e) {
//            throw new DataIntegrityException("Não é possível excluir esta Devolução!");
//        }
//    }

    public Collection<Devolucao> findByClienteAndPeriodo(Integer idCliente, String inicio, String termino){
        return devolucaoRepository.findByClienteAndPeriodo(idCliente, inicio, termino);
    }

    public Collection<?> findQuantidadeDevolucaoClienteByPeriodo(String inicio, String termino){
        return devolucaoRepository.findQuantidadeDevolucaoClienteByPeriodo(inicio, termino);
    }

}
