package com.loca.app.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Cliente extends Pessoa {

    private static final long serialVersionUID = 1L;

    private Double debito;

	@NotNull(message = "Nascimento do Cliente deve ser preenchido")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date nascimento;

	@NotNull(message = "O Cliente deve possuir pelo menos um Telefone")
    @ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();

    @Builder
    public Cliente(Integer id, String nome, String cpf, String rua, Integer numero,
            Bairro bairro, Double debito, Date nascimento) {
//        super(id, nome, cpf, rua, numero, bairro);
        this.debito = debito;
        this.nascimento = nascimento;
    }

}