package br.com.radiotaxi.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.radiotaxi.model.bean.Cliente;
import br.com.radiotaxi.model.bean.Corrida;
import br.com.radiotaxi.model.bean.Motorista;
import br.com.radiotaxi.model.dao.DAO;

@ViewScoped
@ManagedBean
public class CorridaController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3047538927512940307L;
	//Atributos devem ser iniciados
	private Corrida corrida = new Corrida();
	public List<Corrida> corridas;
	
	private List<SelectItem> motoristasSelect;
	private List<SelectItem> clientesSelect;
	
	public CorridaController() {
		System.out.println("Instanciou CorridaBean!");
	}
	
	public List<SelectItem> getMotoristasSelect() {
		if(this.motoristasSelect == null){
			motoristasSelect = new ArrayList<SelectItem>();
			List<Motorista> listaMotoristas = new DAO<Motorista>(Motorista.class).listaTodos();
			if(listaMotoristas != null && !listaMotoristas.isEmpty()){
				SelectItem item;
				for(Motorista motoristaLista : listaMotoristas){
					item = new SelectItem(motoristaLista, 	motoristaLista.getNome() + " - " + motoristaLista.getTaxi().getModelo());
					motoristasSelect.add(item);
				}
			}
		}
		
		return motoristasSelect;
	}
	
	public List<SelectItem> getClientesSelect() {
		if(this.clientesSelect == null){
			clientesSelect = new ArrayList<SelectItem>();
			List<Cliente> listaClientes = new DAO<Cliente>(Cliente.class).listaTodos();
			if(listaClientes != null && !listaClientes.isEmpty()){
				SelectItem item;
				for(Cliente clienteLista : listaClientes){
					item = new SelectItem(clienteLista, clienteLista.getTelefone()+ " - " +clienteLista.getNome());
					clientesSelect.add(item);
				}
			}
		}
		
		return clientesSelect;
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
		FacesContext.getCurrentInstance().addMessage("messages:id",new FacesMessage("Sucesso!")); 
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
