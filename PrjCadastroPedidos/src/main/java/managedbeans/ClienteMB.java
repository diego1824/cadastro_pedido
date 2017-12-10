package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import modelos.Cliente;
import servicos.ClienteServico;

@ManagedBean(name = "ClienteMB")
@ViewScoped
public class ClienteMB {

	private Cliente cliente = new Cliente();
	private ClienteServico cliService = new ClienteServico();
	private List<Cliente> clientes;

	public void salvar() {

		clientes.add(cliente);

		cliService.salvar(cliente);

		cliente = new Cliente();

	}

	public void remove(Cliente cliente) {
		clientes.remove(cliente);
		cliService.remover(cliente);

	}
	
	public void listar(){
		if (cliente != null) {
			cliService.limparCache();
			cliente.getPedidos();
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		if (clientes == null)
			clientes = cliService.getClientes();

		return clientes;
	}

	public void onRowEdit(RowEditEvent event) {

		Cliente c = ((Cliente) event.getObject());
		cliService.alterar(c);
	}

}
