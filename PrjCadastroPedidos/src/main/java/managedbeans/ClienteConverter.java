package managedbeans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelos.Cliente;
import servicos.ClienteServico;

@FacesConverter("converterCliente")
public class ClienteConverter implements Converter {
	ClienteServico cs = new ClienteServico();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			for (Cliente cliente : cs.getClientes()) {
				if (cliente.getNome().equals(value)) {
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
			return ((Cliente)value).getNome();
		}
	}
	
}
