package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import modelos.Pedido;
import modelos.Produto;
import servicos.PedidoServico;
import servicos.ProdutoServico;

@ManagedBean(name = "PedidoMB")
@ViewScoped
public class PedidoMB {

	private Pedido pedido = new Pedido();
	private PedidoServico pedidoService = new PedidoServico();
	private List<Pedido> pedidos;
	private ProdutoServico produtoServico = new ProdutoServico();
	
	public void salvar() {

		pedidos.add(pedido);
		
		pedidoService.salvar(pedido);
		
		for (Produto prod : pedido.getProdutos()) {
			prod.getPedidos().add(pedido);
			produtoServico.alterar(prod);
		}
		
		pedido = new Pedido();

	}

	public void remove(Pedido pedido) {
		pedidos.remove(pedido);
		pedidoService.removePedido(pedido);

	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedidos() {
		if (pedidos == null)
			pedidos = pedidoService.todosPedidos();

		return pedidos;
	}

	public void onRowEdit(RowEditEvent event) {

		Pedido p = ((Pedido) event.getObject());
		pedidoService.atualizar(p);
	}

}
