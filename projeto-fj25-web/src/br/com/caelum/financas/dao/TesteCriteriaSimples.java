package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;

public class TesteCriteriaSimples {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO(em);

		for (Movimentacao movimentacao : dao.todasComCriteria()) {
			System.out.println(movimentacao.getConta().getBanco() + " - " + movimentacao.getConta().getTitular()
					+ " - " + movimentacao.getValor() + " - " + movimentacao.getTags());
		}

	}
}
