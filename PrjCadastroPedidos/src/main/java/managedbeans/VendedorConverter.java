package managedbeans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelos.Vendedor;
import servicos.VendedorServico;

@FacesConverter("converterVendedor")
public class VendedorConverter implements Converter {
	VendedorServico vs = new VendedorServico();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			for (Vendedor vendedor : vs.getVendedores()) {
				if (vendedor.getNome().equals(value)) {
					return vendedor;
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
			return ((Vendedor)value).getNome();
		}
	}
	
}
