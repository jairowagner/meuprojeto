package br.edu.ifrs.canoas.jee.webapp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Pessoa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;

@Stateless
public class GerenciarPessoaService {

	@Inject
	private GerenciarPessoaFisicaService gerenciarPessoaFisicaService;
	@Inject
	private GerenciarPessoaJuridicaService gerenciarPessoaJuridicaService;
	
	public List buscaPessoaFisica(){
		return gerenciarPessoaFisicaService.lista();

	}
	
	public List buscaPessoaJuridica(){
		return gerenciarPessoaJuridicaService.lista();
	}
	
	public Pessoa buscaPessoa(Long id){
		PessoaFisica pessoaFisica = gerenciarPessoaFisicaService.get(id);
		if(pessoaFisica == null) {
			PessoaJuridica pessoaJuridica = gerenciarPessoaJuridicaService.get(id);
			return (Pessoa) pessoaJuridica;
		}else {
			return (Pessoa) pessoaFisica;
		}
	}

}
