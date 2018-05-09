package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@NoArgsConstructor
@Data
@DiscriminatorValue("RESERVADA")
public class DiariaReservada extends Diaria implements Serializable {
	
	private static final long serialVersionUID = -159905495749992552L;
	
	@ManyToOne
	private Reserva reserva;
   
}
