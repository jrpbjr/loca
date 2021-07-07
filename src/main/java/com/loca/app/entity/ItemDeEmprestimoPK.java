package com.loca.app.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

//Classe criada para representar a chave primária composta do objeto ItemDeEmprestimo
@Embeddable
@Data
@EqualsAndHashCode(of = {"emprestimo", "fita"})
public class ItemDeEmprestimoPK implements Serializable {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "emprestimo_id")
  private Emprestimo emprestimo;

  @ManyToOne
  @JoinColumn(name = "fita_id")
  private Fita fita;
  

}
