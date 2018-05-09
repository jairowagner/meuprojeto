package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Pessoa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Reserva;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarPessoaService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarReservaService;
import lombok.Data;

@Named
@RequestScoped
@Data
public class GerenciarReservaMB {

	private Map<String,String> tiposCliente;
	
	@Inject
	private GerenciarReservaService gerenciarReservaService;
	
	@Inject
	private GerenciarPessoaService gerenciarPessoaService;
	
	@Inject
	private GerenciarPessoaMB gerenciarPessoaMB;
	
	@Inject
	private Reserva reserva;

	private List<Reserva> reservas;
	
	private Long idPessoa;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		//reservas = gerenciarReservaService.busca(null);
		reservas = gerenciarReservaService.lista();
	}

	public String salva() {
		Pessoa cliente = gerenciarPessoaService.buscaPessoa(this.idPessoa);
		reserva.setCliente(cliente);
		gerenciarReservaService.salva(reserva);
		this.init();
		return limpa();
	}

	public void edita(Reserva u) {
		this.reserva = u;
	}

	public void exclui() {
		gerenciarReservaService.exclui(reserva);
		this.init();
	}

	public String limpa() {
		reserva = new Reserva();
		return "/public/reserva.jsf?facesRedirect=true";
	}

}
