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

	public String salvar() throws Throwable {
		try {
			tarefaRn.salvar(tarefa);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, " foi cadastrado com sucesso!", ""));
			return "";
		} catch (IllegalArgumentException exception) {
			exception.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Salvar", exception.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Salvar", e.getMessage()));
		}
		return "";
	}

}
