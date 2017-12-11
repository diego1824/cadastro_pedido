package endpoints;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import modelos.Produto;
import servicos.ProdutoServico;

@Path("/produto")
public class RestProduto {
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> getAllProdutos(){
		List<Produto> produtos;
		ProdutoServico prodserv = new ProdutoServico();
		produtos = prodserv.getProdutos();
		return produtos;
	}
	
	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto find(@QueryParam("id") int id){
		ProdutoServico prodserv = new ProdutoServico();
		return prodserv.encontrar(id);
	}
}
