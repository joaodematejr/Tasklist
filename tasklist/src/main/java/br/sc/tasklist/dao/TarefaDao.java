package br.sc.tasklist.dao;

import br.sc.tasklist.entity.Tarefa;

public class TarefaDao extends Dao {

	public void salvar(Tarefa tarefa) {
		getEM().merge(tarefa);

	}

	public Tarefa buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
