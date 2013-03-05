package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaMovimentacao {
	public static void main(String[] args) {
		Movimentacao movimentacao = new Movimentacao();

		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO dao = new ContaDAO(em);

		Conta conta = dao.busca(2);

		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Lalala");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setConta(conta);
		BigDecimal valor = new BigDecimal(10.50);
		movimentacao.setValor(valor);

		em.getTransaction().begin();
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();
	}
}
