package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;

@Stateless
public class ReservaDAO extends BaseDAO<Reserva, Long> {

	private static final long serialVersionUID = 4425539992671256244L;

	@SuppressWarnings("unchecked")
	public List<Reserva> buscaPorCriterio(String criterio){
		return em.createQuery(
		         "SELECT r "
		         + "FROM Reserva r ")
		         .getResultList();
	}
}
