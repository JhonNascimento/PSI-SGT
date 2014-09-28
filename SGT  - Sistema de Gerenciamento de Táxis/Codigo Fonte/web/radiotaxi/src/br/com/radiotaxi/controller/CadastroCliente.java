package br.com.radiotaxi.controller;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.radiotaxi.model.bean.Cliente;
import br.com.radiotaxi.model.dao.DAO;

@ViewScoped
@ManagedBean
public class CadastroCliente  implements Serializable{
	//Atributos devem ser iniciados
	private Cliente cliente = new Cliente();
	public List<Cliente> clientes;
	
	public CadastroCliente () {
		System.out.println("Instanciou ClienteBean!");
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

}
