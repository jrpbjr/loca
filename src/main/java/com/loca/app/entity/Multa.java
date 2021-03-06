package com.loca.app.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

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
public class Multa implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private MultaPK id = new MultaPK();

    @NotNull(message = "Valor da Multa deve ser preenchido")
    @Digits(integer=6, fraction=2, message = "Valor da Multa deve ser preenchido com dígitos")
    private Double valor;

    private Boolean pago;

    @Builder
    public Multa(ItemDeEmprestimo itemDeEmprestimo, Double valor, Boolean pago) {
        this.id.setItemDeEmprestimo(itemDeEmprestimo);
        this.valor = valor;
        this.pago = pago;
    }

    public Integer getEmprestimoId() { //Método criado para facilitar a visualização da chave primária desta devolução
        return id.getItemDeEmprestimo().getEmprestimo().getId();
    }

    public Integer getFitaId() { //Método criado para facilitar a visualização da chave primária desta devolução
        return id.getItemDeEmprestimo().getFita().getId();
    }
    
    public void setEmprestimoId(Integer id) { //Método criado para facilitar a atribuição da chave primária desta devolução
    	Emprestimo emprestimo = new Emprestimo();
    	emprestimo.setId(id);
    	this.id.getItemDeEmprestimo().setEmprestimo(emprestimo);
    }

    public void setFitaId(Integer id) { //Método criado para facilitar a atribuição da chave primária desta devolução
    	Fita fita = new Fita();
    	fita.setId(id);
    	this.id.getItemDeEmprestimo().setFita(fita);
    }

}
