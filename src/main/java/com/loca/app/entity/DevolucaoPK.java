package com.loca.app.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

//Classe criada para representar a chave primária composta do objeto Devolucao
@Embeddable
@Data
@EqualsAndHashCode(of = {"itemDeEmprestimo"})
public class DevolucaoPK implements Serializable {

  private static final long serialVersionUID = 1L;

  @OneToOne
  @JoinColumns({
  	@JoinColumn(name = "FITA_ID", referencedColumnName = "FITA_ID"),
  	@JoinColumn(name = "EMPRESTIMO_ID", referencedColumnName = "EMPRESTIMO_ID")
  })
  private ItemDeEmprestimo itemDeEmprestimo = new ItemDeEmprestimo();

}
