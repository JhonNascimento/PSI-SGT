package br.com.radiotaxi.controller;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.radiotaxi.model.bean.Corrida;
import br.com.radiotaxi.model.dao.DAO;

@ViewScoped
@ManagedBean
public class CorridaController implements Serializable{
	//Atributos devem ser iniciados
	private Corrida corrida = new Corrida();
	public List<Corrida> corridas;
	
	public CorridaController() {
		System.out.println("Instanciou CorridaBean!");
	}
	
	public void salvar(){
		DAO<Corrida> dao = new DAO<Corrida>(Corrida.class);
		if(corrida.getId()!=null){
			dao.alterar(corrida);
		}else{
			dao.cadastrar(corrida);
		}
		corrida  = new Corrida();
		this.corridas = dao.listaTodos();
	}
	
	@PostConstruct
	public List<Corrida> getCorridas() {
		if(this.corridas == null){
			System.out.println("Carregando corridas...");
			this.corridas= new DAO<Corrida>(Corrida.class).listaTodos();
		}
		return this.corridas;
	}
	
	public void limpaFormulario(){
		this.corrida = new Corrida();
	}
	
	public void excluir(Corrida corrida){
		DAO<Corrida> dao = new DAO<Corrida>(Corrida.class);
		dao.remove(corrida);
		this.corridas = dao.listaTodos();
	}
	
	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}

	
}
