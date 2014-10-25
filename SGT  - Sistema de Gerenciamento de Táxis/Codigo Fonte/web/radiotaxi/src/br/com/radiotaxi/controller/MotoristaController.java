package br.com.radiotaxi.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.radiotaxi.model.bean.Bairro;
import br.com.radiotaxi.model.bean.Motorista;
import br.com.radiotaxi.model.dao.DAO;

@ViewScoped
@ManagedBean
public class MotoristaController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2287958247810795489L;
		//Atributos devem ser iniciados
		private Motorista motorista = new Motorista();
		public List<Motorista> motoristas;
		
		private List<SelectItem> bairrosSelect;
		
		public MotoristaController () {
			System.out.println("Instanciou MotoristaBean!");
		}
		
		public List<SelectItem> getBairrosSelect() {
			if(this.bairrosSelect == null){
				bairrosSelect = new ArrayList<SelectItem>();
				List<Bairro> listaBairros = new DAO<Bairro>(Bairro.class).listaTodos();
				if(listaBairros != null && !listaBairros.isEmpty()){
					SelectItem item;
					for(Bairro bairroLista : listaBairros){
						item = new SelectItem(bairroLista, 	bairroLista.getNome());
						bairrosSelect.add(item);
					}
				}
			}
			
			return bairrosSelect;
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
			FacesContext.getCurrentInstance().addMessage("messages:id",new FacesMessage("Sucesso!")); 
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
