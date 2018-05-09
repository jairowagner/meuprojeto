package br.edu.ifrs.canoas.jee.webapp.model.entity;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ifrs.canoas.jee.webapp.model.entity.enums.Sexo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@NoArgsConstructor
@Data
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 850835983473921546L;

	private String cpf;
	private String rg;
	@NotNull @Past( message = "A data deve estar no passado.")
	private Date dataNascimento;
	@Enumerated(EnumType.STRING)    
	private Sexo sexo;
	@ManyToMany
	private List<Diaria> diarias;
	
	@Transient
	public int getIdade() {
		if (this.dataNascimento == null)
			return 0;
		
		Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(this.dataNascimento);
        // Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();
        // Obtém a idade baseado no ano
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        dateOfBirth.add(Calendar.YEAR, age);
        // se a data de hoje é antes da data de Nascimento, então diminui 1.
        if (today.before(dateOfBirth)) {
            age--;
        }
        return age;
	}
   
}
