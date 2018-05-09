package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.dao.ReservaDAO;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;

public class GerenciarReservaService {
	@Inject
	private ReservaDAO reservaDAO;

	public List<Reserva> lista() {
		return reservaDAO.lista();
	}

	public void salva(Reserva reserva) {
		if (reserva.getId() == null)
			reservaDAO.insere(reserva);
		
		reservaDAO.atualiza(reserva);
	}

	public void exclui(Reserva reserva) {
		reservaDAO.exclui(reserva.getId());
	}



}
