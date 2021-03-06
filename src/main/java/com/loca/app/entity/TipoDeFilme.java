package com.loca.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class TipoDeFilme implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	@NotBlank(message = "Nome do Tipo de Filme deve ser preenchido")
	@Size(min = 2, max = 50, message = "Nome do Tipo de Filme deve ter entre 2 e 50 letras")
	private String nome;

	@Digits(integer = 1, fraction = 0, message = "Prazo do Tipo de Filme deve ser preenchido com um valor inteiro")
	private Integer prazo;

	@NotNull(message = "Preço do Tipo de Filme deve ser preenchido")
	@Digits(integer = 2, fraction = 2, message = "Preço do Tipo de Filme deve ser preenchido com um valor decimal")
	private Double preco;

}
