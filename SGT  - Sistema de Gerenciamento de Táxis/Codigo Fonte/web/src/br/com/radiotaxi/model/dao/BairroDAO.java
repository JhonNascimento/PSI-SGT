package br.com.radiotaxi.model.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.radiotaxi.model.bean.Bairro;
@SuppressWarnings("unchecked")
public class BairroDAO {

	private EntityManager entityManager;
	
	public BairroDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Bairro bairro){
		entityManager.persist(bairro);
	}
	public void alterar(Bairro bairro){
		entityManager.merge(bairro);
	}
	public void excluir(Bairro bairro){
		entityManager.remove(entityManager.merge(bairro));
	}
	public Bairro consultar(Long id){
		return entityManager.getReference(Bairro.class, id);
	}
	public List<Bairro> listar(){
		String jpql = "Select p from Bairro p order by nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
