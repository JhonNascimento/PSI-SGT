package br.com.radiotaxi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.radiotaxi.model.dao.UsuarioDAO;
import br.com.radiotaxi.model.bean.Usuario;

@ManagedBean 
@SessionScoped
public class LoginController {

	private Usuario usuario = new Usuario();

	public String efetuaLogout(){
		this.usuario = new Usuario();
		return "login?faces-redirect=true";
	}
	
	//action com outcome
	public String efetuaLogin(){
		UsuarioDAO dao = new UsuarioDAO();
		boolean loginValido = dao.existe(this.usuario);
		if(loginValido){
			return "principal?faces-redirect=true";
		}else{
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public boolean isLogado(){
		return this.usuario.getLogin() != null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

}
