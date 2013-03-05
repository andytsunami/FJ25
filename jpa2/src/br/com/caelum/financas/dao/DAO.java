package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class DAO<T> {
	private final EntityManager em;
	private final Class<T> classe;

	public DAO(EntityManager em, Class<T> classe) {
		this.em = em;
		this.classe = classe;
	}

	public T busca(Integer id) {
		return em.getReference(classe, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> lista() {
		return em.createQuery("select e from " + classe.getName() + " e").getResultList();
	}

	public void remove(T entidade) {
		em.remove(entidade);
	}

	public void adiciona(T entidade) {
		em.persist(entidade);

	}

	public void altera(T entidade) {
		em.merge(entidade);
	}
}
