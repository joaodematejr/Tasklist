package br.sc.tasklist.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import br.sc.tasklist.rn.TarefaRn;
import br.sc.tasklist.entity.Tarefa;

@ViewScoped
@ManagedBean
public class TarefaMb {
	private Tarefa tarefa;
	private TarefaRn tarefaRn;
	private List<Tarefa> listarTarefas;
	private Long editarId;

	@PostConstruct
	public void init() {
		tarefa = new Tarefa();
		tarefaRn = new TarefaRn();
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public TarefaRn getTarefaRn() {
		return tarefaRn;
	}

	public void setTarefaRn(TarefaRn tarefaRn) {
		this.tarefaRn = tarefaRn;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public List<Tarefa> getListarTarefas() {
		if (listarTarefas == null) {
			listarTarefas = tarefaRn.listarTarefas();

		}
		return listarTarefas;
	}

	public void setListarTarefas(List<Tarefa> listarTarefas) {
		this.listarTarefas = listarTarefas;
	}

	// Botão Salvar
	public String salvar() throws Throwable {
		tarefaRn.salvar(tarefa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Foi cadastrado com sucesso!"));
		return "adicionartarefa.xhtml";

	}

	public String Limpar() {
		return "adicionartarefa.xhtml";

	}

}
