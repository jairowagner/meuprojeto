package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import br.edu.ifrs.canoas.jee.webapp.model.dao.BaseDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaJuridicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.util.Mensagens;

@Stateless
public class GerenciarPessoaJuridicaService {

	@Inject
	private Logger log;
	

	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO;

	public List<PessoaJuridica> lista() {
		return pessoaJuridicaDAO.lista();
	}
	
	public PessoaJuridica get(Long id) {
		return pessoaJuridicaDAO.busca(id);
	}
	public boolean salva(PessoaJuridica pessoaJuridica) {
		log.info("Salvando " + pessoaJuridica.getNome());
		pessoaJuridicaDAO.insere(pessoaJuridica);		
		return true;
	}
	
	
	public void exclui(PessoaJuridica pessoaJuridica) {		
		try {
			pessoaJuridicaDAO.exclui(pessoaJuridica.getId());		
			Mensagens.define(FacesMessage.SEVERITY_INFO, "PessoaJuridica.excluido.sucesso",pessoaJuridica.getNome());	
			log.info("Excluido " + pessoaJuridica.getNome() + " com id " + pessoaJuridica.getId());
		}catch (EJBTransactionRolledbackException e) {			
			Mensagens.define(FacesMessage.SEVERITY_ERROR, "PessoaJuridica.excluido.erro.constraintViolation",pessoaJuridica.getNome());	
			log.info("ConstraintViolationException " + pessoaJuridica.getNome() + " com id " + pessoaJuridica.getId());
		}catch (Exception e1) {		
			 Mensagens.define(FacesMessage.SEVERITY_ERROR, "PessoaJuridica.excluido.erro.constraintViolation",pessoaJuridica.getNome());			 
			log.info("Exception " + pessoaJuridica.getNome() + " com id " + pessoaJuridica.getId() + " "+e1.getMessage());
		}
	}
	
	
	

}
