package com.loca.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.loca.app.entity.enums.StatusReserva;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date data;

	@Digits(integer = 1, fraction = 0, message = "Número da Casa da Pessoa deve ser preenchido com um valor inteiro")
	private Integer status;

	@NotNull(message = "O Cliente da Reserva deve ser preenchido")
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@NotNull(message = "A Fita da Reserva deve ser preenchida")
	@ManyToOne
	@JoinColumn(name = "fita_id")
	private Fita fita;

	@Builder
	public Reserva(Integer id, Date data, StatusReserva status, Cliente cliente, Fita fita) {
		this.id = id;
		this.data = data;
		this.status = (status == null) ? null : status.getCod();
		this.cliente = cliente;
		this.fita = fita;
	}

	public StatusReserva getStatus() {
		return StatusReserva.toEnum(status);
	}

	public void setStatus(StatusReserva status) {
		this.status = status.getCod();
	}

}