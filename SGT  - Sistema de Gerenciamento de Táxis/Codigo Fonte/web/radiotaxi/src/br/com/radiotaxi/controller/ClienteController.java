package br.com.radiotaxi.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.radiotaxi.model.bean.Bairro;
import br.com.radiotaxi.model.bean.Cliente;
import br.com.radiotaxi.model.dao.ClienteDAO;
import br.com.radiotaxi.model.dao.DAO;

@ViewScoped
@ManagedBean
public class ClienteController  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//Atributos devem ser iniciados
	private Cliente cliente = new Cliente();
	public List<Cliente> clientes;
	
	private List<SelectItem> bairrosSelect;
	
	public ClienteController () {
		System.out.println("Instanciou ClienteBean!");
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
		DAO<Cliente> dao = new DAO<Cliente>(Cliente.class);
		if(cliente.getId()!=null){
			dao.alterar(cliente);
		}else{
			dao.cadastrar(cliente);
		}
		this.cliente = new Cliente();
		this.clientes = dao.listaTodos();
		FacesContext.getCurrentInstance().addMessage("messages:id",new FacesMessage("Sucesso!")); 
	}
	
	public List<Cliente> getClientes() {
		if(this.clientes == null){
			System.out.println("Carregando clientes...");
			this.clientes = new DAO<Cliente>(Cliente.class).listaTodos();
		}
		return this.clientes;
	}
	
	public void limpaFormulario(){
		this.cliente = new Cliente();
	}
	
	public void excluir(Cliente cliente){
		DAO<Cliente> dao = new DAO<Cliente>(Cliente.class);
		dao.remove(cliente);
		this.clientes = dao.listaTodos();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void filtrarMovimento(String telefone){
        System.out.println("jho :"+telefone);
        ClienteDAO dao = new ClienteDAO();
        
        if(telefone != null && !telefone.isEmpty()){
            dao.getListaFiltro(this.cliente);
        }else{
        	DAO<Bairro> daodao = new DAO<Bairro>(Bairro.class);
            daodao.listaTodos();
        }

    }

}
