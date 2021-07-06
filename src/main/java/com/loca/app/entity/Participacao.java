package com.loca.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Participacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    @NotBlank(message = "Personagem da Participação deve ser preenchido")
    @Size(min = 2, max = 50, message = "Personagem da Participação deve ter entre 2 e 50 letras")
    private String personagem;

    @JsonIgnore //Evitando referência cíclica
    @NotNull(message = "O Filme da Participação deve ser preenchido")
    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @NotNull(message = "O Artista da Participação deve ser preenchido")
    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

}
