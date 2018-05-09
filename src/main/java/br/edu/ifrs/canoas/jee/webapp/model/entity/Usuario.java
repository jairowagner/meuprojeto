package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lombok.Data;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Data
public class Usuario extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 6262524988798723388L;

	@NotNull @Email  private String email;
	@NotNull @Size(min=6, max=8) @Pattern(regexp = "[a-zA-Z0-9]+", message="#{validacao.letras}") private String senha;
	@NotNull private String nome;
	private String sobrenome;
	private String telefone;
	
}
