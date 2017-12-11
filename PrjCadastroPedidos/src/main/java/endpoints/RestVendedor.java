package endpoints;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import modelos.Vendedor;
import servicos.VendedorServico;

@Path("/vendedor")
public class RestVendedor {
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vendedor> getAllVendedores(){
		List<Vendedor> vendedores;
		VendedorServico vendser = new VendedorServico();
		vendedores = vendser.getVendedores();
		return vendedores;
	}
	
	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Vendedor find(@QueryParam("id") int id){
		VendedorServico vendser = new VendedorServico();
		return vendser.encontrar(id);
	}
}
