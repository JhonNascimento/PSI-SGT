package br.com.radiotaxi.controller;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.radiotaxi.model.bean.Usuario;
import br.com.radiotaxi.model.dao.DAO;

/**
 * Servlet implementation class UsuariosController
 */

@ViewScoped
@ManagedBean
public class UsuarioController implements Serializable{
	/**
	 * 
	 */
	
	//Atributos devem ser iniciados
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	public UsuarioController(){
		System.out.println("Instanciou UsuarioBean!");
	}
	
	public void salvar(){
		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		if(usuario.getId()!=null){
			dao.alterar(usuario);
		}else{
			dao.cadastrar(usuario);
		}
		this.usuario = new Usuario();
		this.usuarios = dao.listaTodos();
	}

	@PostConstruct
	public List<Usuario> getUsuarios(){
		if(this.usuarios == null){
			System.out.println("Carregando usuarios...");
			this.usuarios = new DAO<Usuario>(Usuario.class).listaTodos();
		}
		return this.usuarios;
	}
	
	public void limpaFormulario(){
		this.usuario = new Usuario();
	}
	
	public void excluir(Usuario usuario){
		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		dao.remove(usuario);
		this.usuarios = dao.listaTodos();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}