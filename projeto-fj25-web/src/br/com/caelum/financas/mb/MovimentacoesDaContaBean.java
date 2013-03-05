package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

@ManagedBean
public class MovimentacoesDaContaBean {
	private List<Movimentacao> movimentacoes;
	private Conta conta = new Conta();
	@ManagedProperty(name = "em", value = "#{requestScope.em}")
	private EntityManager em = new JPAUtil().getEntityManager();

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void lista() {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		this.movimentacoes = dao.listaTodasMovimentacoes(conta);
		System.out.println("Listando as movimentacoes da conta");
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
