package br.edu.ifrs.canoas.jee.webapp.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifrs.canoas.jee.webapp.model.entity.Quarto;
import br.edu.ifrs.canoas.jee.webapp.model.entity.Usuario;
import br.edu.ifrs.canoas.jee.webapp.model.entity.enums.TipoDeQuarto;
import br.edu.ifrs.canoas.jee.webapp.service.GerenciarQuartoService;
import lombok.Data;

@Named
@RequestScoped
@Data
public class GerenciarQuartoMB {

	@Inject
	private GerenciarQuartoService gerenciarQuartoService;
	@Inject
	private Quarto quarto;

	private List<Quarto> quartos;
	
	private List<TipoDeQuarto> tipoDeQuartos;

	@PostConstruct
	public void init() {
		quartos = gerenciarQuartoService.lista();
		tipoDeQuartos = Arrays.asList(TipoDeQuarto.values());
	}

	public String salva() {
		gerenciarQuartoService.salva(quarto);
		this.init();
		return limpa();
	}

	public void edita(Quarto q) {
		this.quarto = q;
	}

	public void exclui() {
		gerenciarQuartoService.exclui(quarto);
		this.init();
	}

	public String limpa() {
		quarto = new Quarto();
		return "/public/quarto.jsf?facesRedirect=true";
	}
	
	public HashMap<String, String> quartosMap(){
		HashMap<String, String> mapaDeQuartos = new HashMap<String, String>();
		for(Quarto q: quartos) {
			mapaDeQuartos.put(q.getId().toString(), q.getNumero());
		}
		return mapaDeQuartos;
	}
	
 

}
