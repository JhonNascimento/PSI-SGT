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
	private String logradouro;
	private String pagamento;
	private String valor;
	
	@ManyToOne
	private Motorista motorista;
	
	@ManyToOne
	private Cliente cliente;
	
	@Temporal(TemporalType.DATE)
	private Calendar data = Calendar.getInstance();

	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getPagamento() {
		return pagamento;
	}
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	
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
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
