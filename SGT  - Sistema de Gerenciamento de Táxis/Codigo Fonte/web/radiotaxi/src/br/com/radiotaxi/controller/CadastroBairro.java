package br.com.radiotaxi.controller;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.radiotaxi.model.bean.Bairro;
import br.com.radiotaxi.model.dao.DAO;

@ViewScoped
@ManagedBean
public class CadastroBairro implements Serializable{
	//Atributos devem ser iniciados
	private Bairro bairro = new Bairro();
	public List<Bairro> bairros;
	
	public CadastroBairro() {
		System.out.println("Instanciou BairroBean!");
	}
	
	public void salvar(){
		DAO<Bairro> dao = new DAO<Bairro>(Bairro.class);
		if(bairro.getId()!=null){
			dao.alterar(bairro);
		}else{
			dao.cadastrar(bairro);
		}
		bairro  = new Bairro();
		this.bairros = dao.listaTodos();
	}
	
	@PostConstruct
	public List<Bairro> getBairros() {
		if(this.bairros == null){
			System.out.println("Carregando bairros...");
			this.bairros= new DAO<Bairro>(Bairro.class).listaTodos();
		}
		return this.bairros;
	}
	
	public void limpaFormulario(){
		this.bairro = new Bairro();
	}
	
	public void excluir(Bairro bairro){
		DAO<Bairro> dao = new DAO<Bairro>(Bairro.class);
		dao.remove(bairro);
		this.bairros = dao.listaTodos();
	}
	
	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	
}
