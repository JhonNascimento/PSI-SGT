package br.com.radiotaxi.model.bean;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Turistico {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String logradouro;
	private String bairro;
	private String cidade;
	
	//Metodos de GET e SET...
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
