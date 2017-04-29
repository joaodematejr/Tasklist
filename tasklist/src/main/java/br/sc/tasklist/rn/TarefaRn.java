package br.sc.tasklist.rn;

import java.util.List;

import br.sc.tasklist.dao.TarefaDao;
import br.sc.tasklist.entity.Tarefa;

public class TarefaRn {
	private TarefaDao dao;

	public TarefaRn() {
		dao = new TarefaDao();
	}

	public Tarefa buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public void salvar(Tarefa tarefa) {
		dao.salvar(tarefa);
	}

	public List<Tarefa> listarTarefas() {
		return dao.listarTarefas();
	}

	public void excluir(Long id) {
		dao.excluir(id);

	}

}
