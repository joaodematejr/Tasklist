package br.sc.tasklist.dao;

import java.util.List;
import javax.persistence.Query;
import br.sc.tasklist.entity.Tarefa;

public class TarefaDao extends Dao {

	public Tarefa buscarPorId(Long id) {
		return getEM().find(Tarefa.class, id);
	}

	// Salvar No Banco
	public void salvar(Tarefa tarefa) {
		getEM().merge(tarefa);

	}

	// Listar todas as Tarefas do Banco
	@SuppressWarnings("unchecked")
	public List<Tarefa> listarTarefas() {
		Query query = getEM().createQuery("From Tarefa", Tarefa.class);//
		return query.getResultList();

	}

	// Excluir do Banco
	public void excluir(Long id) {
		Tarefa tarefa = getEM().getReference(Tarefa.class, id);
		getEM().remove(tarefa);

	}
}
