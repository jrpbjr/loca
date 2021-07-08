package com.loca.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Artista implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	@NotBlank(message = "Nome do Artista deve ser preenchido")
	@Size(min = 2, max = 50, message = "Nome do Artista deve ter entre 2 e 50 letras")
	private String nome;

	@Size(min = 1, message = "Imagem do Artista deve ser preenchida")
	@Lob
	@Type(type = "org.hibernate.type.ImageType") // Esta notação é necessário para funcionar no Postgresql
	private byte[] imagem;

}
