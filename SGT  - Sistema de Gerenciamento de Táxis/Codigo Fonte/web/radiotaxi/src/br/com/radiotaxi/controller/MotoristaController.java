package br.com.radiotaxi.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.radiotaxi.model.bean.Bairro;
import br.com.radiotaxi.model.bean.Motorista;
import br.com.radiotaxi.model.dao.MotoristaDAO;
import br.com.radiotaxi.model.dao.DAO;

@ViewScoped
@ManagedBean
public class MotoristaController implements Serializable{
	//Atributos devem ser iniciados
		private Motorista motorista = new Motorista();
		public List<Motorista> motoristas;
		
		public MotoristaController () {
			System.out.println("Instanciou MotoristaBean!");
		}
		
		public void salvar(){
			DAO<Motorista> dao = new DAO<Motorista>(Motorista.class);
			if(motorista.getId()!=null){
				dao.alterar(motorista);
			}else{
				dao.cadastrar(motorista);
			}
			this.motorista = new Motorista();
			this.motoristas = dao.listaTodos();
		}
		
		public List<Motorista> getMotoristas() {
			if(this.motoristas == null){
				System.out.println("Carregando motoristas...");
				this.motoristas = new DAO<Motorista>(Motorista.class).listaTodos();
			}
			return this.motoristas;
		}
		
		public void limpaFormulario(){
			this.motorista = new Motorista();
		}
		
		public void excluir(Motorista motorista){
			DAO<Motorista> dao = new DAO<Motorista>(Motorista.class);
			dao.remove(motorista);
			this.motoristas = dao.listaTodos();
		}
		
		public Motorista getMotorista() {
			return motorista;
		}

		public void setMotorista(Motorista motorista) {
			this.motorista = motorista;
		}

}
