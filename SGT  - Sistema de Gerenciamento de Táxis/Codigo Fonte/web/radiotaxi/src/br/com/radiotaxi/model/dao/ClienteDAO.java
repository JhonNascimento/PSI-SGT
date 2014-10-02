package br.com.radiotaxi.model.dao;
import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.radiotaxi.model.bean.Cliente;
@SuppressWarnings("unchecked")
public class ClienteDAO {
	
	public List<Cliente> getListaFiltro(Cliente cliente){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
        Query query = em.createQuery("SELECT c from Cliente c where telefone = :telefone order by c.nome");
        query.setParameter("telefone", cliente.getTelefone());
        
        List<Cliente> movimentos = (List<Cliente>) query.getResultList();

        return movimentos;
    }
	
}
