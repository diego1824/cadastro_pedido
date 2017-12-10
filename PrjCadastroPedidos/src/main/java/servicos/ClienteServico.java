package servicos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelos.Cliente;

public class ClienteServico extends Servico {

	public void salvar(Cliente cliente) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();

	}

	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes() {

		List<Cliente> clientes;

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select c From Cliente c");
		clientes = q.getResultList();
		em.close();

		return clientes;
	}

	public void alterar(Cliente cliente) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		em.close();
	}

	public void remover(Cliente cliente) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		cliente = em.find(Cliente.class, cliente.getCodigo());
		em.remove(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
	public Cliente encontrar(Integer id){
		EntityManager em = emf.createEntityManager();
		Cliente cli = em.find(Cliente.class, id);
		em.close();
		return cli;
	}

}
