package com.loca.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Devolucao implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private DevolucaoPK id = new DevolucaoPK();

    @NotNull(message = "Data da Devolução deve ser preenchida")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;

//    @Builder
//    public Devolucao(ItemDeEmprestimo itemDeEmprestimo, Date data) {
//    	this.id.setItemDeEmprestimo(itemDeEmprestimo);
//        this.data = data;
//    }
//
//    public Integer getEmprestimoId() { //Método criado para facilitar a visualização da chave primária desta devolução
//        return id.getItemDeEmprestimo().getEmprestimo().getId();
//    }
//
//    public Integer getFitaId() { //Método criado para facilitar a visualização da chave primária desta devolução
//        return id.getItemDeEmprestimo().getFita().getId();
//    }
//    
//    public void setEmprestimoId(Integer id) { //Método criado para facilitar a atribuição da chave primária desta devolução
//    	Emprestimo emprestimo = new Emprestimo();
//    	emprestimo.setId(id);
//    	this.id.getItemDeEmprestimo().setEmprestimo(emprestimo);
//    }
//
//    public void setFitaId(Integer id) { //Método criado para facilitar a atribuição da chave primária desta devolução
//    	Fita fita = new Fita();
//    	fita.setId(id);
//    	this.id.getItemDeEmprestimo().setFita(fita);
//    }
    

}