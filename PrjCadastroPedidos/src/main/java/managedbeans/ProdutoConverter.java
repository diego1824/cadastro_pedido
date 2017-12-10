package managedbeans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelos.Produto;
import servicos.ProdutoServico;

@FacesConverter("converterProduto")
public class ProdutoConverter implements Converter {
	ProdutoServico ps = new ProdutoServico();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			for (Produto cliente : ps.getProdutos()) {
				if (cliente.getDescricao().equals(value)) {
					return cliente;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
			return null;
		}else{
			return ((Produto)value).getDescricao();
		}
	}
	
}
