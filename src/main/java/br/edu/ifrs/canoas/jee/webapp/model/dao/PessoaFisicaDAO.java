package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;

@Stateless
public class PessoaFisicaDAO extends BaseDAO<PessoaFisica, Long> {

	private static final long serialVersionUID = -6532078438454378708L;

	@SuppressWarnings("unchecked")
	public List<PessoaFisica> busca(PessoaFisica pf) {

		if (pf == null)
			return new ArrayList<PessoaFisica>();

		CriteriaQuery<PessoaFisica> query = builder().createQuery(PessoaFisica.class);
		Root<PessoaFisica> from = query.from(PessoaFisica.class);

		Predicate predicate = builder().and();

		if (pf.getId() != null)
			predicate = builder().and(predicate, builder().equal(
					from.get("id"), pf.getId()));
		
		if (!StringUtils.isBlank(pf.getNome()))
			predicate = builder().and(predicate, builder().like(
					from.get("nome"), pf.getNome().trim().toLowerCase()));
		
		if (!StringUtils.isBlank(pf.getCpf()))
			predicate = builder().and(predicate,
					builder().like(from.get("cpf"), pf.getCpf().trim().toLowerCase()));
		
		if (!StringUtils.isBlank(pf.getRg()))
			predicate = builder().and(predicate,
					builder().like(from.get("rg"), pf.getRg().trim().toLowerCase()));
		
//		if (!StringUtils.isBlank(pf.getSexo()))
//			predicate = builder().and(predicate,
//					builder().like(from.get("sexo"), pf.getSexo().trim().toLowerCase()));
		
		return em.createQuery(query
				.select(from)
				.where(predicate)
				.orderBy(builder().asc(from.get("nome"))))
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<PessoaFisica> buscaPorCriterio(String criterio){
		return em.createQuery(
		         "SELECT pf "
		         + "FROM PessoaFisisca pf "
		         + "WHERE pf.id = :id "
		         + " or lower(pf.email) = :email "
		         + " or lower (pf.nome) = :nome ")
		         .setParameter("id", criterio.trim().toLowerCase())
		         .setParameter("email", criterio.trim().toLowerCase())
		         .setParameter("nome", criterio.trim().toLowerCase())
		         .getResultList();
	}
}