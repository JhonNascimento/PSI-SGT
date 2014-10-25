package br.com.radiotaxi.controller;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.radiotaxi.model.bean.Turistico;
import br.com.radiotaxi.model.dao.DAO;


@ViewScoped
@ManagedBean
public class TuristicoController implements Serializable{
	//Atributos devem ser iniciados
	private Turistico turistico = new Turistico();
	public List<Turistico> turisticos;
	
	public TuristicoController() {
		System.out.println("Instanciou TuristicoBean!");
	}
	
	public void salvar(){
		DAO<Turistico> dao = new DAO<Turistico>(Turistico.class);
		if(turistico.getId()!=null){
			dao.alterar(turistico);
		}else{
			dao.cadastrar(turistico);
		}
		turistico  = new Turistico();
		this.turisticos = dao.listaTodos();
		FacesContext.getCurrentInstance().addMessage("messages:id",new FacesMessage("Sucesso!")); 
	}
	
	@PostConstruct
	public List<Turistico> getTuristicos() {
		if(this.turisticos == null){
			System.out.println("Carregando pontos turisticos...");
			this.turisticos= new DAO<Turistico>(Turistico.class).listaTodos();
		}
		return this.turisticos;
	}
	
	public void limpaFormulario(){
		this.turistico = new Turistico();
	}
	
	public void excluir(Turistico turistico){
		DAO<Turistico> dao = new DAO<Turistico>(Turistico.class);
		dao.remove(turistico);
		this.turisticos = dao.listaTodos();
	}
	
	public Turistico getTuristico() {
		return turistico;
	}

	public void setTuristico(Turistico turistico) {
		this.turistico = turistico;
	}

	
}
