package br.sc.tasklist.dao;

import javax.persistence.EntityManager;
import br.sc.tasklist.commons.JpaUtils;

public abstract class Dao {
	private EntityManager entityManager = null;

	public Dao() {
		super();
	}

	public Dao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEM() {
		if (this.entityManager == null) {
			return JpaUtils.geEntityManager();
		}
		return this.entityManager;
	}
}
