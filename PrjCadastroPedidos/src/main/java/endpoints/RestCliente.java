package endpoints;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import modelos.Cliente;
import servicos.ClienteServico;

@Path("/cliente")
public class RestCliente {
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> getAllClientes(){
		List<Cliente> clientes;
		ClienteServico cliserv = new ClienteServico();
		clientes = cliserv.getClientes();
		return clientes;
	}
	
	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente find(@QueryParam("id") int id){
		ClienteServico cliserv = new ClienteServico();
		return cliserv.encontrar(id);
	}
}
