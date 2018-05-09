package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarPessoaJuridicaService;
import lombok.Data;

@Named
@RequestScoped
@Data
public class GerenciarPessoaJuridicaMB {

	@Inject
	private GerenciarPessoaJuridicaService gerenciarPessoaJuridicaService;

	@Inject
	private PessoaJuridica pessoaJuridica;

	private List<PessoaJuridica> pessoaJuridicas;
	private List<PessoaJuridica> pessoaJuridicasFiltradas;

	@PostConstruct
	public void init() {
		this.pessoaJuridicas = gerenciarPessoaJuridicaService.lista();
	}

	public String salva() {
		gerenciarPessoaJuridicaService.salva(pessoaJuridica);
		this.init();
		return limpa();
	}

	public void edita(PessoaJuridica pf) {
		this.pessoaJuridica = pf;
	}

	public void exclui() {
		gerenciarPessoaJuridicaService.exclui(pessoaJuridica);
		this.init();
	}

	public String limpa() {
		pessoaJuridica = new PessoaJuridica();
		return "/public/pessoaJuridica.jsf?facesRedirect=true";
	}


}
