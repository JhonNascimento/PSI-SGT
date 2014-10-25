package br.com.radiotaxi.controller;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.radiotaxi.model.bean.Estado;
import br.com.radiotaxi.model.dao.DAO;

@ViewScoped
@ManagedBean
public class EstadoController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -244785346947570218L;
	//Atributos devem ser iniciados
	private Estado estado = new Estado();
	public List<Estado> estados;
	
	public EstadoController() {
		System.out.println("Instanciou EstadoBean!");
	}
	
	public void salvar(){
		DAO<Estado> dao = new DAO<Estado>(Estado.class);
		if(estado.getId()!=null){
			dao.alterar(estado);
		}else{
			dao.cadastrar(estado);
		}
		estado  = new Estado();
		this.estados = dao.listaTodos();
		FacesContext.getCurrentInstance().addMessage("messages:id",new FacesMessage("Sucesso!")); 
	}
	
	@PostConstruct
	public List<Estado> getEstados() {
		if(this.estados == null){
			System.out.println("Carregando estados...");
			this.estados = new DAO<Estado>(Estado.class).listaTodos();
		}
		return this.estados;
	}
	
	public void limpaFormulario(){
		this.estado = new Estado();
	}
	
	public void excluir(Estado estado){
		DAO<Estado> dao = new DAO<Estado>(Estado.class);
		dao.remove(estado);
		this.estados = dao.listaTodos();
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
}
