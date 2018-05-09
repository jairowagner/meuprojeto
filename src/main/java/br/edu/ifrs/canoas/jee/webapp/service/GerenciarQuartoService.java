package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.QuartoDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;

@Stateless
public class GerenciarQuartoService {
	@Inject
	private QuartoDAO quartoDAO;

	public List<Quarto> lista() {
		return quartoDAO.lista();
	}

	public void salva(Quarto quarto) {
		if (quarto.getId() == null)
			quartoDAO.insere(quarto);
		
		quartoDAO.atualiza(quarto);
	}

	public void exclui(Quarto quarto) {
		quartoDAO.exclui(quarto.getId());
	}
	
	
}
