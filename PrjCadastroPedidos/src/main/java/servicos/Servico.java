package servicos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Servico {

    protected static EntityManagerFactory emf;
	
	public Servico()
	{
	      emf = Persistence.createEntityManagerFactory("PrjCadastroPedidos");
	}
	
	public void limparCache(){
		EntityManager em = emf.createEntityManager();
		em.getEntityManagerFactory().getCache().evictAll();
	}
	
}
