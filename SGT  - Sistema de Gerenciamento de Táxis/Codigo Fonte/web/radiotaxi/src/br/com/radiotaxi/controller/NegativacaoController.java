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
import br.com.radiotaxi.model.bean.Motorista;
import br.com.radiotaxi.model.bean.Negativacao;
import br.com.radiotaxi.model.dao.DAO;

@ViewScoped
@ManagedBean
public class NegativacaoController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Atributos devem ser iniciados
	private Negativacao negativacao = new Negativacao();
	public List<Negativacao> negativacoes;
	
	private List<SelectItem> motoristasSelect;
	private List<SelectItem> clientesSelect;
	
	public NegativacaoController() {
		System.out.println("Instanciou BairroBean!");
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
		DAO<Negativacao> dao = new DAO<Negativacao>(Negativacao.class);
		if(negativacao.getId()!=null){
			dao.alterar(negativacao);
		}else{
			dao.cadastrar(negativacao);
		}
		negativacao  = new Negativacao();
		this.negativacoes = dao.listaTodos();
		FacesContext.getCurrentInstance().addMessage("messages:id",new FacesMessage("Sucesso!")); 
	}
	
	@PostConstruct
	public List<Negativacao> getNegativacoes() {
		if(this.negativacoes == null){
			System.out.println("Carregando negativacoes...");
			this.negativacoes= new DAO<Negativacao>(Negativacao.class).listaTodos();
		}
		return this.negativacoes;
	}
	
	public void limpaFormulario(){
		this.negativacao = new Negativacao();
	}
	
	public void excluir(Negativacao negativacao){
		DAO<Negativacao> dao = new DAO<Negativacao>(Negativacao.class);
		dao.remove(negativacao);
		this.negativacoes = dao.listaTodos();
	}
	
	public Negativacao getNegativacao() {
		return negativacao;
	}

	public void setNegativacao(Negativacao negativacao) {
		this.negativacao = negativacao;
	}
	
}
