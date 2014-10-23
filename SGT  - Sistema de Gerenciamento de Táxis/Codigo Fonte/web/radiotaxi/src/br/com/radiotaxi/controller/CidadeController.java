package br.com.radiotaxi.controller;
import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.radiotaxi.model.bean.Cidade;
import br.com.radiotaxi.model.dao.DAO;

@ViewScoped
@ManagedBean
public class CidadeController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos devem ser iniciados
	private Cidade cidade = new Cidade();
	public List<Cidade> cidades;
	
	public CidadeController() {
		System.out.println("Instanciou CidadeBean!");
	}
	
	public void salvar(){
		DAO<Cidade> dao = new DAO<Cidade>(Cidade.class);
		if(cidade.getId()!=null){
			dao.alterar(cidade);
		}else{
			dao.cadastrar(cidade);
		}
		cidade  = new Cidade();
		this.cidades = dao.listaTodos();
	}
	
	@PostConstruct
	public List<Cidade> getCidades() {
		if(this.cidades == null){
			System.out.println("Carregando cidades...");
			this.cidades = new DAO<Cidade>(Cidade.class).listaTodos();
		}
		return this.cidades;
	}
	
	public void limpaFormulario(){
		this.cidade = new Cidade();
	}
	
	public void excluir(Cidade cidade){
		DAO<Cidade> dao = new DAO<Cidade>(Cidade.class);
		dao.remove(cidade);
		this.cidades = dao.listaTodos();
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	
}
