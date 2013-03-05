package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		EntityManager entityManager = new JPAUtil().getEntityManager();

		ContaDAO dao = new ContaDAO(entityManager);

		Conta conta = new Conta();
		conta.setTitular("ContaDAO");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0999");

		entityManager.getTransaction().begin();
		dao.adiciona(conta);
		entityManager.getTransaction().commit();
		entityManager.close();

		long fim = System.currentTimeMillis();

		System.out.println("Conta gravada com sucesso!\n Executado em: " + (fim - inicio));
	}
}
