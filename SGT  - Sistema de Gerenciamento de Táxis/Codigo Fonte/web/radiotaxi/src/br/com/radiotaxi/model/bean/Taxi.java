package br.com.radiotaxi.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.radiotaxi.converter.AbstractEntity;

@Entity
public class Taxi  extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1681115435353862260L;
	@Id
	@GeneratedValue
	private Long id;
	private String placa;
	private String ano;
	private String marca;
	private String modelo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	

}
