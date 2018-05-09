package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.PessoaFisicaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.util.Mensagens;

@Stateless
public class GerenciarPessoaFisicaService {

	@Inject
	private Logger log;

	@Inject
	private PessoaFisicaDAO pessoaFisicaDAO;

	public List<PessoaFisica> lista() {
		return pessoaFisicaDAO.lista();
	}

	public PessoaFisica get(Long id) {
		return pessoaFisicaDAO.busca(id);
	}

	public boolean salva(PessoaFisica pessoaFisica) {
		// log.info("Salvando " + pessoaFisica.getNome());
		// if (pessoaFisica.getId() == null)
		// pessoaFisicaDAO.insere(pessoaFisica);
		//
		// pessoaFisicaDAO.atualiza(pessoaFisica);
		//
		// return true;

		log.info("Salvando " + pessoaFisica.getNome());

		if (pessoaFisica.getIdade() > 18) {
			if (pessoaFisica.getId() != null) {
				// Atualizar:
				pessoaFisicaDAO.atualiza(pessoaFisica);
				Mensagens.define(FacesMessage.SEVERITY_INFO, "pessoaFisica.atualizada.sucesso",
						pessoaFisica.getNome());
				return true;
			}
			// Inserir:
			pessoaFisicaDAO.insere(pessoaFisica);
			Mensagens.define(FacesMessage.SEVERITY_INFO, "pessoaFisica.cadastrada.sucesso", pessoaFisica.getNome());
			log.info("Salvo " + pessoaFisica.getNome() + " com id " + pessoaFisica.getId());
			return true;
		} else {
			Mensagens.define(FacesMessage.SEVERITY_ERROR, "pessoaFisica.cadastrada.idade.menor18", pessoaFisica.getNome());
			return false;
		}
	}

	public void exclui(PessoaFisica pessoaFisica) {
		try {
			pessoaFisicaDAO.exclui(pessoaFisica.getId());
			Mensagens.define(FacesMessage.SEVERITY_INFO, "pessoaFisica.excluida.sucesso", pessoaFisica.getNome());
			log.info("Excluido " + pessoaFisica.getNome() + " com id " + pessoaFisica.getId());
			// } catch(Throwable e) {
			// } catch(Exception e) {
		} catch (EJBTransactionRolledbackException e) {
			// } catch(RollbackException e) {
			// } catch(PersistenceException e) {
			// } catch(JdbcSQLException e) {
			// e.printStackTrace();
			Mensagens.define(FacesMessage.SEVERITY_INFO, "pessoaFisica.naoExcluida.existeDiarias",
					pessoaFisica.getNome());
			log.info("Pessoa " + pessoaFisica.getNome() + " com id " + pessoaFisica.getId()
					+ " tem diárias, não pode ser exlcuída");
		}
	}

}
