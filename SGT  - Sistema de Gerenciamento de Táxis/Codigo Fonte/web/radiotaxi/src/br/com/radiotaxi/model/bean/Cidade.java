package br.com.radiotaxi.model.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.radiotaxi.converter.AbstractEntity;
@Entity
public class Cidade extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 677060029592189345L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@ManyToOne
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
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
}
