package servicos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelos.Produto;

public class ProdutoServico extends Servico {

	public void salvar(Produto produto) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();

	}

	@SuppressWarnings("unchecked")
	public List<Produto> getProdutos() {

		List<Produto> produtos;

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select p From Produto p");
		produtos = q.getResultList();
		em.close();

		return produtos;
	}

	public void alterar(Produto produto) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		em.close();
	}

	public void remover(Produto produto) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		produto = em.find(Produto.class, produto.getCodigo());
		em.remove(produto);
		em.getTransaction().commit();
		em.close();
	}

	public Produto encontrar(Integer id) {
		EntityManager em = emf.createEntityManager();
		Produto prod = em.find(Produto.class, id);
		em.close();
		return prod;
	}

}
