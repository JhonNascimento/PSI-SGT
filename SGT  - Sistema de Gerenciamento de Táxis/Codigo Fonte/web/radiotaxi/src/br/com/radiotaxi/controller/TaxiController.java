package br.com.radiotaxi.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.radiotaxi.model.bean.Taxi;
import br.com.radiotaxi.model.dao.DAO;

@ViewScoped
@ManagedBean
public class TaxiController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7891999300871169549L;
	
	private Taxi taxi = new Taxi();
	public List<Taxi> taxis;
	
	public TaxiController() {
		System.out.println("Instanciou TaxiBean!");
	}
	
	public void salvar(){
		DAO<Taxi> dao = new DAO<Taxi>(Taxi.class);
		if(taxi.getId()!=null){
			dao.alterar(taxi);
		}else{
			dao.cadastrar(taxi);
		}
		taxi  = new Taxi();
		this.taxis = dao.listaTodos();
		FacesContext.getCurrentInstance().addMessage("messages:id",new FacesMessage("Sucesso!")); 
	}
	
	@PostConstruct
	public List<Taxi> getTaxis() {
		if(this.taxis == null){
			System.out.println("Carregando taxis...");
			this.taxis = new DAO<Taxi>(Taxi.class).listaTodos();
		}
		return this.taxis;
	}
	
	public void limpaFormulario(){
		this.taxi = new Taxi();
	}
	
	public void excluir(Taxi taxi){
		DAO<Taxi> dao = new DAO<Taxi>(Taxi.class);
		dao.remove(taxi);
		this.taxis = dao.listaTodos();
	}
	
	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}

}
