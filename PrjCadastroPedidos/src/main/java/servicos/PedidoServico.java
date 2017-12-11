package servicos;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelos.Pedido;
@ApplicationScoped
public class PedidoServico {
	private EntityManagerFactory emf;
	public PedidoServico(){
		emf = Persistence.createEntityManagerFactory("CadastrosFinal");
	}
	
	public void salvar(Pedido pedido){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pedido);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Pedido> todosPedidos(){
		EntityManager em = emf.createEntityManager();
		List p = em.createQuery("Select p from Pedido p").getResultList();
		em.close();
		return p;
	}
	//atualiza pra valer no banco
	public void atualizar(Pedido p){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}
	//da refresh
	public Pedido update(Pedido pedidoSelecionado) {
		EntityManager em = emf.createEntityManager();
		Pedido p = em.find(Pedido.class, pedidoSelecionado.getCodigo());
		em.refresh(p);
		em.close();

		return p;
	}
	
	public boolean removePedido(Pedido pedido) {

		boolean sucesso = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Pedido p = em.find(Pedido.class, pedido.getCodigo());
			em.remove(p);
			em.getTransaction().commit();
			em.close();
			sucesso = true;
		} catch (Exception e) {

		}

		return sucesso;

	}
	
//	public List<Aluno> todosAlunosDeUmPedido(Pedido procurar){
//		List<Aluno> lista = null;
//		EntityManager em = emf.createEntityManager();
//		Pedido c = em.find(Pedido.class, procurar.getCodigo());
//		em.refresh(c);
//		lista = c.getAlunos();
//		em.close();
//		return lista;
//	}
	
}
