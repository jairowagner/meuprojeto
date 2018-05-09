package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_PESSOA")
public abstract class Pessoa extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 6019880333458919264L;

	@NotNull @Size(min=2, max=100,message="#{pessoa.nome}")private String nome;
	//@NotNull @Pattern(regexp="\\(\\d{2}\\)\\ \\d{4}-\\d{4}")
	@NotNull private String telefone;
	@NotNull @Email private String email;
	
	@OneToOne
	private Endereco endereco;
	@OneToMany(mappedBy="cliente")
	private List<DiariaAvulsa> diariasAvulsas;
	@OneToMany(mappedBy="cliente")
	private List<Reserva> reservas;
   
	@Transient
	public String getCpfCnpj() {
		if (this instanceof PessoaFisica)
			return ((PessoaFisica)this).getCpf();
		else if(this instanceof PessoaJuridica)
			return ((PessoaJuridica)this).getCnpj();
		
		return null;
	}
}


