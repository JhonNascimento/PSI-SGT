package br.com.radiotaxi.model.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.radiotaxi.converter.AbstractEntity;
@Entity
public class Estado extends AbstractEntity{
	
	private static final long serialVersionUID = 208869213063847988L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String sigla;
	
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
