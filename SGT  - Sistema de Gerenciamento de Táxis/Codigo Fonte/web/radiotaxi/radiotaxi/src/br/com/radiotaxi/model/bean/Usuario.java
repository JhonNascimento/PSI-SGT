package br.com.radiotaxi.model.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String email;
	private String login;
	private String senha;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String verificarUsuario(){
	    if(Usuario.isUsuarioValido(login, senha))
	      return "sucesso";
	    else
	      return "erro";
	  }
	
	public static boolean isUsuarioValido(String login, String senha){
		    String user = "adm";
		    String pass = "123";

		    if((login.equals(user)) && (senha.equals(pass)))
		      return true;

		    return false;
		  }
	
}
