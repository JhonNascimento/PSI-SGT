package br.com.radiotaxi.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.radiotaxi.model.bean.Usuario;
import br.com.radiotaxi.model.dao.JPAUtil;
import br.com.radiotaxi.model.dao.UsuarioDAO;

/**
 * Servlet implementation class UsuariosController
 */

@ViewScoped
@ManagedBean
public class CadastroUsuario {
	//Atributos devem ser iniciados
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//Atributo que guarda a colecao produtos armazenados em BD
	public List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}	

	//Metodo invocado apos a classe ser carregada pelo servidor
	@PostConstruct
	public void carregarUsuarios(){
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		listaUsuarios = dao.listar();
		em.close();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		em.getTransaction().begin();
		dao.excluir(usuario);
		em.getTransaction().commit();
		em.close();
		carregarUsuarios();
	}

	public void salvar(){
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		em.getTransaction().begin();
		if(usuario.getId()!=null){
			dao.alterar(usuario);
		}else{
			dao.cadastrar(usuario);
		}
		em.getTransaction().commit();
		em.close();
		usuario  = new Usuario();
		carregarUsuarios();
	}
}