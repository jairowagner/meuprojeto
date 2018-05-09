
package br.edu.ifrs.canoas.jee.webapp.model.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;

@Stateless
public class PessoaJuridicaDAO extends BaseDAO<PessoaJuridica, Long> {

	private static final long serialVersionUID = -6532078438454378708L;
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscaPorCriterio(String criterio){
		return em.createQuery(
		         "SELECT u "
		         + "FROM PessoaJuridica u "
		         + "WHERE lower(u.email) = :email "
		         + " or lower (u.nome) = :nome "
		         + " or lower (u.razaoSocial) = :razaoSocial "
		         + " or lower (u.inscricaoEstadual) = :inscricaoEstadual "
		         + " or lower (u.inscricaoMunicipal) = :inscricaoMunicipal "
		         + " or lower (u.cnpj) =  :cnpj ")
		         .setParameter("email", criterio.trim().toLowerCase())
		         .setParameter("nome", criterio.trim().toLowerCase())
		         .setParameter("razaoSocial", criterio.trim().toLowerCase())
		         .setParameter("inscricaoEstadual", criterio.trim().toLowerCase())
		         .setParameter("inscricaoMunicipal", criterio.trim().toLowerCase())
		         .setParameter("cnpj", criterio.trim().toLowerCase())
		         .getResultList();
	}
}
