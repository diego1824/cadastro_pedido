package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;


import modelos.Produto;
import servicos.ProdutoServico;

@ManagedBean(name = "ProdutoMB")
@ViewScoped
public class ProdutoMB {

	private Produto produto = new Produto();
	private ProdutoServico prodService = new ProdutoServico();
	private List<Produto> produtos;

	public void salvar() {

		produtos.add(produto);

		prodService.salvar(produto);

		produto = new Produto();

	}

	public void remove(Produto produto) {
		produtos.remove(produto);
		prodService.remover(produto);

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		if (produtos == null)
			produtos = prodService.getProdutos();

		return produtos;
	}

	public void onRowEdit(RowEditEvent event) {

		Produto p = ((Produto) event.getObject());
		prodService.alterar(p);
	}

}
