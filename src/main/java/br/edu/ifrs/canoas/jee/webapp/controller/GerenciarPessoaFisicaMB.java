package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarPessoaFisicaService;
import lombok.Data;

@Named
@RequestScoped
@Data
public class GerenciarPessoaFisicaMB {

	@Inject
	private GerenciarPessoaFisicaService gerenciarPessoaFisicaService;
	@Inject
	private PessoaFisica pessoaFisica;

	private List<PessoaFisica> pessoasFisicas;
	private List<PessoaFisica> PessoaFisicaFiltradas;

	@PostConstruct
	public void init() {
		pessoasFisicas = gerenciarPessoaFisicaService.lista();
	}

	public String salva() {
		if (gerenciarPessoaFisicaService.salva(pessoaFisica)) {
			this.init();
			return limpa();
		}
		return "/public/pessoaFisica.jsf?facesRedirect=false";
	}

	public void edita(PessoaFisica pf) {
		this.pessoaFisica = pf;
	}

	public void exclui() {
		gerenciarPessoaFisicaService.exclui(pessoaFisica);
		this.init();
	}

	public String limpa() {
		pessoaFisica = new PessoaFisica();
		return "/public/pessoaFisica.jsf?facesRedirect=true";
	}

}
