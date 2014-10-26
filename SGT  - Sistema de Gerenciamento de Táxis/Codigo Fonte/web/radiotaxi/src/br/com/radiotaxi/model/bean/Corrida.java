package br.com.radiotaxi.model.bean;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.radiotaxi.converter.AbstractEntity;

@Entity
public class Corrida extends AbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1093253701450978332L;
	@Id
	@GeneratedValue
	private Long id;
	private String cliente;
	private String logradouro;

	@ManyToOne
	private Motorista motorista;
	
	@ManyToOne
	private Bairro bairro;
	
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	@Temporal(TemporalType.DATE)
	private Calendar data = Calendar.getInstance();
	
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
}
