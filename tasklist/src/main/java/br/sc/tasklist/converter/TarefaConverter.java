package br.sc.tasklist.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.sc.tasklist.entity.Tarefa;
import br.sc.tasklist.rn.TarefaRn;

@FacesConverter(forClass = Tarefa.class)
public class TarefaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		TarefaRn tarefaRn = new TarefaRn();
		Long id = Long.parseLong(value);
		return tarefaRn.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Tarefa tarefa = (Tarefa) value;
		return String.valueOf(tarefa.getId());
	}

}
