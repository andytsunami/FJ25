package br.com.caelum.financas.mb;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@ManagedBean
public class TotalMovimentadoBean {
	private BigDecimal total;
	private Conta conta = new Conta();
	private TipoMovimentacao tipoMovimentacao;

	public void setEm(EntityManager em) {
	}

	public void calcula() {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		this.total = dao.calculaTotalMovimentacao(conta, tipoMovimentacao);
		System.out.println("Total movimentado pela conta");
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

}
