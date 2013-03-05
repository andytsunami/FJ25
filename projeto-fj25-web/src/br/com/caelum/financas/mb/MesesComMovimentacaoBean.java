package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.ValorPorMesAno;

@ManagedBean
public class MesesComMovimentacaoBean {

	private final Conta conta = new Conta();

	private TipoMovimentacao tipoMovimentacao;

	private List<ValorPorMesAno> listaMesesComMovimentacoes;

	public void setEm(EntityManager em) {
	}

	public void lista() {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		this.listaMesesComMovimentacoes = dao.listaMesesComMovimentacoes(conta, tipoMovimentacao);
		em.close();

		System.out.println("Listando as contas pelos valores movimentados no mês");
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Conta getConta() {
		return conta;
	}

	public List<ValorPorMesAno> getValoresPorMesEAno() {
		return listaMesesComMovimentacoes;

	}
}
