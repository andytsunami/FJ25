package br.com.caelum.financas.mb;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@ManagedBean
public class MovimentacoesPorValorETipoBean {
	private List<Movimentacao> movimentacoes;
	private BigDecimal valor;
	private TipoMovimentacao tipoMovimentacao;

	public void setEm(EntityManager em) {
	}

	public void lista() {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		this.movimentacoes = dao.listaPorValorETipo(valor, tipoMovimentacao);

		System.out.println("Buscando movimentacoes por valor e tipo");

	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

}
