package br.com.caelum.financas.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.lucene.analysis.br.BrazilianAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.util.Version;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.ValorPorMesAno;

public class MovimentacaoDAO {

	private final DAO<Movimentacao> dao;
	private final EntityManager em;

	public MovimentacaoDAO(EntityManager em) {
		dao = new DAO<Movimentacao>(em, Movimentacao.class);
		this.em = em;
	}

	public void adiciona(Movimentacao t) {
		dao.adiciona(t);
	}

	public Movimentacao busca(Integer id) {
		return dao.busca(id);
	}

	public List<Movimentacao> lista() {
		return dao.lista();
	}

	public void remove(Movimentacao t) {
		dao.remove(t);
	}

	public List<Movimentacao> listaTodasMovimentacoes(Conta conta) {
		String jpql = "select m from Movimentacao m where m.conta = :conta order by m.valor desc";
		Query query = this.em.createQuery(jpql);
		query.setParameter("conta", conta);
		return query.getResultList();
	}

	public List<Movimentacao> listaPorValorETipo(BigDecimal valor, TipoMovimentacao tipo) {
		String jpql = "select m from Movimentacao m where m.valor <= :valor and m.tipoMovimentacao = :tipo";
		Query query = this.em.createQuery(jpql);
		query.setParameter("valor", valor);
		query.setParameter("tipo", tipo);
		query.setHint("org.hibernate.cacheable", "true");
		return query.getResultList();

	}

	public BigDecimal calculaTotalMovimentacao(Conta conta, TipoMovimentacao tipo) {
		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :conta and m.tipoMovimentacao = :tipo";
		TypedQuery<BigDecimal> query = this.em.createQuery(jpql, BigDecimal.class);
		query.setParameter("conta", conta);
		query.setParameter("tipo", tipo);
		return query.getSingleResult();

	}

	public List<Movimentacao> buscaTodasMovimentacoesDaConta(String titular) {
		String jpql = "select m from Movimentacao m where m.conta.titular like :titular";
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("titular", "%" + titular + "%");
		return query.getResultList();
	}

	public List<ValorPorMesAno> listaMesesComMovimentacoes(Conta conta, TipoMovimentacao tipoMovimentacao) {
		String jpql = "select new br.com.caelum.financas.modelo.ValorPorMesAno(month(m.data),year(m.data),sum(m.valor)) "
				+ "from Movimentacao m where m.conta = :conta and m.tipoMovimentacao = :tipo "
				+ "group by year(m.data)||month(m.data) order by sum(m.valor) desc";
		Query query = this.em.createQuery(jpql);
		query.setParameter("tipo", tipoMovimentacao);
		query.setParameter("conta", conta);
		List<ValorPorMesAno> lista = query.getResultList();
		return lista;
	}

	public List<Movimentacao> todasComCriteria() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> criteria = builder.createQuery(Movimentacao.class);
		criteria.from(Movimentacao.class);
		return em.createQuery(criteria).getResultList();
	}

	public BigDecimal somaMovimentacoesDoTitular(String titular) {
		CriteriaBuilder busca = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> criteria = busca.createQuery(BigDecimal.class);
		Root<Movimentacao> alias = criteria.from(Movimentacao.class);
		criteria.select(busca.sum(alias.<BigDecimal> get("valor")));
		criteria.where(busca.like(alias.<Conta> get("conta").<String> get("titular"), titular));

		return this.em.createQuery(criteria).getSingleResult();
	}

	public List<Movimentacao> pesquisa(Conta conta, TipoMovimentacao tipoMovimentacao, Integer mes) {
		CriteriaBuilder busca = this.em.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> criteria = busca.createQuery(Movimentacao.class);
		Root<Movimentacao> alias = criteria.from(Movimentacao.class);
		Predicate condicao = busca.conjunction();
		if (conta.getId() != null) {
			condicao = busca.and(condicao, busca.equal(alias.<Conta> get("conta"), conta));
		}
		if (mes != null && mes != 0) {
			Expression<Integer> expression = busca.function("month", Integer.class, alias.<Calendar> get("data"));
			busca.and(condicao, busca.equal(expression, mes));

		}
		if (tipoMovimentacao != null) {
			condicao = busca.and(condicao,
					busca.equal(alias.<TipoMovimentacao> get("tipoMovimentacao"), tipoMovimentacao));
		}
		criteria.where(condicao);
		return this.em.createQuery(criteria).getResultList();
	}

	public List<Movimentacao> buscaMovimentacaoBaseadoNasTags(String texto) {
		FullTextEntityManager ftem = Search.getFullTextEntityManager(em);

		QueryParser parser = new QueryParser(Version.LUCENE_29, "tags.nome", new BrazilianAnalyzer(Version.LUCENE_29));

		try {
			org.apache.lucene.search.Query query = parser.parse(texto);
			FullTextQuery textQuery = ftem.createFullTextQuery(query, Movimentacao.class);
			return textQuery.getResultList();
		} catch (ParseException e) {
			// TODO: handle exception
			throw new IllegalArgumentException(e);

		}

	}
}
