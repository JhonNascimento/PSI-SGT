package br.com.radiotaxi.controller;
import java.util.ArrayList;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.radiotaxi.model.bean.Cliente;
import br.com.radiotaxi.model.dao.ClienteDAO;
import br.com.radiotaxi.model.dao.JPAUtil;

@ViewScoped
@ManagedBean
public class CadastroCliente {
	//Atributos devem ser iniciados
	private Cliente cliente = new Cliente();
	
	public Cliente getCliente () {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente= cliente;
	}
	
	//Atributo que guarda a colecao produtos armazenados em BD
	public List<Cliente> listaClientes = new ArrayList<Cliente >();
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}	

	//Metodo invocado apos a classe ser carregada pelo servidor
	@PostConstruct
	public void carregarClientes(){
		EntityManager em = JPAUtil.getEntityManager();
		ClienteDAO dao = new ClienteDAO(em);
		listaClientes = dao.listar();
		em.close();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		ClienteDAO dao = new ClienteDAO(em);
		em.getTransaction().begin();
		dao.excluir(cliente);
		em.getTransaction().commit();
		em.close();
		carregarClientes();
	}

	public void salvar(){
		EntityManager em = JPAUtil.getEntityManager();
		ClienteDAO dao = new ClienteDAO(em);
		em.getTransaction().begin();
		if(cliente.getId()!=null){
			dao.alterar(cliente);
		}else{
			dao.cadastrar(cliente);
		}
		em.getTransaction().commit();
		em.close();
		cliente  = new Cliente();
		carregarClientes();
	}
}
