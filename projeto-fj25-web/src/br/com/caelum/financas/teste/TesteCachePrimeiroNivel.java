package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TesteCachePrimeiroNivel {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		Conta conta1 = em.find(Conta.class, 9);
		Conta conta2 = em.find(Conta.class, 9);

		System.out.println("Titular da primeira conta: " + conta1.getTitular());
		System.out.println("Titular da segunda conta: " + conta2.getTitular());

		if (conta1 == conta2) {
			System.out.println("Iguais champs!!");
		}

	}
}
