package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.DiariaAvulsaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.dao.QuartoDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Diaria;
import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.util.Mensagens;

public class GerenciarDiariaService {
	
	@Inject
	private DiariaAvulsaDAO diariaDAO;

	public List<DiariaAvulsa> lista(String criterio) {
		if (criterio != null && criterio.length() > 0) 
			return diariaDAO.buscaPorCriterio(criterio);
		else
			return diariaDAO.lista();
	}

	public boolean salva(DiariaAvulsa diaria) {
		if (diaria.getId() != null) {
			diariaDAO.atualiza(diaria);
			Mensagens.define(FacesMessage.SEVERITY_INFO, "Diaria Avulsa sucesso");
			return true;
		} 
		
		diariaDAO.insere(diaria);
		Mensagens.define(FacesMessage.SEVERITY_INFO, "Diaria Avulsa sucesso ");
		return true;		
	}

	public List<DiariaAvulsa> busca(Object object) {
		return diariaDAO.lista();
	}

	public void exclui(DiariaAvulsa diaria) {
		diariaDAO.exclui(diaria.getId());
		
	}
}
