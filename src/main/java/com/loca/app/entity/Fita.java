package com.loca.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Fita implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "O atributo 'danificada' da Fita deve ser preenchido")
	private Boolean danificada;

	@NotNull(message = "O atributo 'disponivel' da Fita deve ser preenchido")
	@NotNull(message = "O Filme da Fita deve ser preenchido")
	private Boolean disponivel;

	@NotNull(message = "O Filme da Fita deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;

}
