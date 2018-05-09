package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Diaria;
import br.edu.ifrs.canoas.jee.webapp.model.entity.DiariaAvulsa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Pessoa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarDiariaService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarPessoaService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarUsuarioService;
import lombok.Data;

@Named
@RequestScoped
@Data
public class GerenciarDiariaMB {

	@Inject
	private GerenciarDiariaService gerenciarDiariaService;
	@Inject
	private DiariaAvulsa diaria;
	@Inject
	private GerenciarPessoaService gerenciarPessoaService;
	private List<DiariaAvulsa> diarias;
	private List<DiariaAvulsa> diariasFiltradas;
	private Long idPessoa;

	@PostConstruct
	public void init() {
		diarias = gerenciarDiariaService.busca(null);
	}

	public String salva() {
		Pessoa cliente = gerenciarPessoaService.buscaPessoa(this.idPessoa);
		if(cliente != null)
		   diaria.setCliente(cliente);
		
		gerenciarDiariaService.salva(diaria);
		this.init();
		return limpa();
	}

	public void edita(DiariaAvulsa d) {
		this.diaria = d;
	}

	public void exclui() {
		gerenciarDiariaService.exclui(diaria);
		this.init();
	}

	public String limpa() {
		diaria = new DiariaAvulsa();
		return "/public/diaria.jsf?facesRedirect=true";
	}

}
