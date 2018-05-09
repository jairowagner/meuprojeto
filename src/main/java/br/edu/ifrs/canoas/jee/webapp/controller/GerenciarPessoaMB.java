package br.edu.ifrs.canoas.jee.webapp.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Pessoa;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaFisica;
import br.edu.ifrs.canoas.jee.webapp.model.entity.PessoaJuridica;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarPessoaFisicaService;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarPessoaService;
import lombok.Data;



@Named
@javax.faces.view.ViewScoped
@Data
public class GerenciarPessoaMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1515720560668531475L;

	@Inject
	private GerenciarPessoaService gerenciarPessoaService;
	
	private List pessoas;
	
	private Map<String,String> tiposPessoa;
	private String tipoPessoa;

	
	private Pessoa pessoa;

	@PostConstruct
	public void init() {
		this.tiposPessoa  = new HashMap<String, String>();
		this.tiposPessoa.put( "Pessoa Física", "PF");
		this.tiposPessoa.put("Pessoa Jurídica", "PJ");
		
//		this.pessoasFisicas = gerenciarPessoaService.buscaPessoaFisica();	
//		this.pessoasJuridicas = gerenciarPessoaService.buscaPessoaJuridica();	
	}
	
	public void onTipoPessoaChange() {

		pessoas = this.tipoPessoa.equals("PF") ? gerenciarPessoaService.buscaPessoaFisica() : gerenciarPessoaService.buscaPessoaJuridica();


    }

	

	


}
