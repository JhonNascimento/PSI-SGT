package br.com.radiotaxi.controller;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.radiotaxi.model.bean.Bairro;
import br.com.radiotaxi.model.bean.Apoio;
import br.com.radiotaxi.model.dao.DAO;


@ViewScoped
@ManagedBean
public class ApoioController implements Serializable{
	//Atributos devem ser iniciados
	private Apoio apoio = new Apoio();
	public List<Apoio> apoios;
	private List<SelectItem> bairrosSelect;

	
	public ApoioController() {
		System.out.println("Instanciou ApoioBean!");
	}
	
	public List<SelectItem> getBairrosSelect() {
		if(this.bairrosSelect == null){
			bairrosSelect = new ArrayList<SelectItem>();
			List<Bairro> listaBairros = new DAO<Bairro>(Bairro.class).listaTodos();
			if(listaBairros != null && !listaBairros.isEmpty()){
				SelectItem item;
				for(Bairro bairroLista : listaBairros){
					item = new SelectItem(bairroLista, 	bairroLista.getNome());
					bairrosSelect.add(item);
				}
			}
		}
		
		return bairrosSelect;
	}
	
	public void salvar(){
		DAO<Apoio> dao = new DAO<Apoio>(Apoio.class);
		if(apoio.getId()!=null){
			dao.alterar(apoio);
		}else{
			dao.cadastrar(apoio);
		}
		apoio  = new Apoio();
		this.apoios = dao.listaTodos();
	}
	
	@PostConstruct
	public List<Apoio> getApoios() {
		if(this.apoios == null){
			System.out.println("Carregando pontos apoios...");
			this.apoios= new DAO<Apoio>(Apoio.class).listaTodos();
		}
		return this.apoios;
	}
	
	public void limpaFormulario(){
		this.apoio = new Apoio();
	}
	
	public void excluir(Apoio apoio){
		DAO<Apoio> dao = new DAO<Apoio>(Apoio.class);
		dao.remove(apoio);
		this.apoios = dao.listaTodos();
	}
	
	public Apoio getApoio() {
		return apoio;
	}

	public void setApoio(Apoio apoio) {
		this.apoio = apoio;
	}

	
}
