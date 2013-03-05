package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;

@ManagedBean
public class MovimentacoesPorTitularBean {

	private List<Movimentacao> movimentacoes;
	private String titular;

	public void setEm(EntityManager em) {
	}

	public void lista() {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		movimentacoes = dao.buscaTodasMovimentacoesDaConta(titular);

		System.out.println("Buscando as movimentacoes pelo titular da conta");
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}