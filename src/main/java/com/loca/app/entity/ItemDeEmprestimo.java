package com.loca.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
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
public class ItemDeEmprestimo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemDeEmprestimoPK id = new ItemDeEmprestimoPK();

    @NotNull(message = "Valor do Item de Empréstimo deve ser preenchido")
    @Digits(integer=6, fraction=2, message = "Valor do Item de Empréstimo deve ser preenchido com dígitos")
    private Double valor;

    @NotNull(message = "Entrega do Item de Empréstimo deve ser preenchida")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date entrega;

    @Builder
    public ItemDeEmprestimo(Emprestimo emprestimo, Fita fita, Double valor, Date entrega) {
        
    	    	
    	this.id.setEmprestimo(emprestimo);
        this.id.setFita(fita);
        this.valor = valor;
        this.entrega = entrega;
    }

    @JsonIgnore
    public Emprestimo getEmprestimo() {
        return id.getEmprestimo();
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        id.setEmprestimo(emprestimo);
    }

    public Fita getFita() {
        return id.getFita();
    }

    public void setFita(Fita fita) {
        id.setFita(fita);
    }
    
}