package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@NoArgsConstructor
@Data
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa implements Serializable {
	
	private static final long serialVersionUID = -6727809382071338488L;
	
	@NotNull @Size(min=2, max=100,message="#{pessoa.razaoSocial}")private String razaoSocial;
	@NotNull @CNPJ private String cnpj;
	@NotNull @Size(min=0, max=30,message="#{pessoa.inscricaoEstadual}") private String inscricaoEstadual;
	@NotNull @Size(min=0, max=30,message="#{pessoa.inscricaoMunicipal}") private String inscricaoMunicipal;
}
