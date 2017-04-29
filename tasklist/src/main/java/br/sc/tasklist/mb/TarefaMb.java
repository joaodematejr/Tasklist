package br.sc.tasklist.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.hibernate.engine.internal.TwoPhaseLoad;

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

	// Botão Salvar, e validar os campos 
	public String salvar() throws Throwable {
		if (tarefa.getTitulo() != null && tarefa.getTitulo().length() >= 3
				|| tarefa.getDescricao() != null && tarefa.getDescricao().length() >= 3) {
			tarefaRn.salvar(tarefa);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sua Tarefa foi registrada com sucesso!", ""));
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ops ! alguns campos estão incompletos", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

		return "adicionartarefa.xhtml";

	}

	// Limpar campos do formulario
	public String Limpar() {
		return "adicionartarefa.xhtml";

	}

	// Excluir do banco
	public String excluir(String id) throws Throwable {
		Long idExcluir = Long.parseLong(id);
		tarefaRn.excluir(idExcluir);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Deletado com Sucesso", ""));
		return "listartarefa.xhtml";

	}

	// CarregarDados
	public void carregarTarefa(ComponentSystemEvent event) {
		if (editarId == null) {
			return;
		}
		tarefa = tarefaRn.buscarPorId(editarId);
	}

}
