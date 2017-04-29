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
		Query query = getEM().createQuery("FROM Tarefa", Tarefa.class);//
		return query.getResultList();

	}

	// Excluir do Banco
	public void excluir(Long id) {
		Tarefa tarefa = getEM().getReference(Tarefa.class, id);
		getEM().remove(tarefa);

	}

	public Tarefa buscarPorTitulo(String titulo) {
		Query query = getEM().createQuery("SELECT t FROM Tarefa t WHERE t.titulo = :titulo");
		query.setParameter("titulo", titulo);
		try {
			return (Tarefa) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}
}
