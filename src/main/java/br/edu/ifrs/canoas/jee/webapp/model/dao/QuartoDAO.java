package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;

@Stateless
public class QuartoDAO extends BaseDAO<Quarto, Long> {

	private static final long serialVersionUID = 1740776420611568097L;
	
	@SuppressWarnings("unchecked")
	public List<Quarto> buscaPorCriterio(String criterio){
		return em.createQuery(
		         "SELECT q "
		         + "FROM Quarto q "
		         + "WHERE disponivel = :disponivel ")
		         .setParameter("disponivel", criterio.trim())
		         .getResultList();
	}
	
}