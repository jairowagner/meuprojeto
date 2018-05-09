package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.ifrs.canoas.jee.webapp.model.entity.enums.TipoDeQuarto;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Usuario	
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Quarto extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 8671579293612635068L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private String numero;
	
	@Enumerated(EnumType.STRING)    
	private TipoDeQuarto tipo = TipoDeQuarto.DUPLO;
	private Boolean disponivel = true;
	private String descricao;
}
