package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;

public class DiariaAvulsaDAO extends BaseDAO<DiariaAvulsa, Long>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4151528843904040541L;
	
	
	@SuppressWarnings("unchecked")
	public List<DiariaAvulsa> busca(DiariaAvulsa diaria) {

		if (diaria == null)
			return new ArrayList<DiariaAvulsa>();

		CriteriaQuery<DiariaAvulsa> query = builder().createQuery(DiariaAvulsa.class);
		Root<DiariaAvulsa> from = query.from(DiariaAvulsa.class);

		Predicate predicate = builder().and();

		if (!StringUtils.isBlank(diaria.getCliente().getId().toString()))
			predicate = builder().and(predicate, builder().like(
					from.get("cliente_id"), diaria.getCliente().getId().toString()));
		
		return em.createQuery(query
				.select(from)
				.where(predicate)
				.orderBy(builder().asc(from.get("id"))))
				.getResultList();

	}


	public List<DiariaAvulsa> buscaPorCriterio(String criterio) {
		// TODO Auto-generated method stub
		return null;
	}


}
