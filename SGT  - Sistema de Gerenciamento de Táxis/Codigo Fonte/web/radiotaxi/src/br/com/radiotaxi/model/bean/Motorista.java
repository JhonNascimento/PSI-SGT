package br.com.radiotaxi.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.radiotaxi.converter.AbstractEntity;
@Entity
public class Motorista extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783004818514229413L;
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String telefone;
	private String cnh;
	private String rg;
	private String datanascimento;
	private String logradouro;
	private String cep;
	
	@ManyToOne
	private Bairro bairro;
	
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
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
	public String getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
