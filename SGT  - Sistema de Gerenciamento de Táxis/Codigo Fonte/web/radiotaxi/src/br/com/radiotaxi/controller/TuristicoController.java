package br.com.radiotaxi.controller;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.radiotaxi.model.bean.Bairro;
import br.com.radiotaxi.model.bean.Turistico;
import br.com.radiotaxi.model.dao.DAO;


@ViewScoped
@ManagedBean
public class TuristicoController implements Serializable{
	//Atributos devem ser iniciados
	private Turistico turistico = new Turistico();
	public List<Turistico> turisticos;
	private List<SelectItem> bairrosSelect;

	
	public TuristicoController() {
		System.out.println("Instanciou TuristicoBean!");
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
		DAO<Turistico> dao = new DAO<Turistico>(Turistico.class);
		if(turistico.getId()!=null){
			dao.alterar(turistico);
		}else{
			dao.cadastrar(turistico);
		}
		turistico  = new Turistico();
		this.turisticos = dao.listaTodos();
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
