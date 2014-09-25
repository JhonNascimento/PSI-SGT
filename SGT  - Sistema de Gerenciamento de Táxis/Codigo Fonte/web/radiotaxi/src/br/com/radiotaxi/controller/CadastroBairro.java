package br.com.radiotaxi.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.radiotaxi.model.bean.Bairro;
import br.com.radiotaxi.model.dao.BairroDAO;
import br.com.radiotaxi.model.dao.JPAUtil;

@ViewScoped
@ManagedBean
public class CadastroBairro {
	//Atributos devem ser iniciados
	private Bairro bairro = new Bairro();
	
	public Bairro getBairro() {
		return bairro;
	}
	
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	//Atributo que guarda a colecao produtos armazenados em BD
	public List<Bairro> listaBairros = new ArrayList<Bairro>();
	
	public List<Bairro> getListaBairros() {
		return listaBairros;
	}	

	//Metodo invocado apos a classe ser carregada pelo servidor
	@PostConstruct
	public void carregarBairros(){
		EntityManager em = JPAUtil.getEntityManager();
		BairroDAO dao = new BairroDAO(em);
		listaBairros = dao.listar();
		em.close();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		BairroDAO dao = new BairroDAO(em);
		em.getTransaction().begin();
		dao.excluir(bairro);
		em.getTransaction().commit();
		em.close();
		carregarBairros();
	}

	public void salvar(){
		EntityManager em = JPAUtil.getEntityManager();
		BairroDAO dao = new BairroDAO(em);
		em.getTransaction().begin();
		if(bairro.getId()!=null){
			dao.alterar(bairro);
		}else{
			dao.cadastrar(bairro);
		}
		em.getTransaction().commit();
		em.close();
		bairro  = new Bairro();
		carregarBairros();
	}
}
