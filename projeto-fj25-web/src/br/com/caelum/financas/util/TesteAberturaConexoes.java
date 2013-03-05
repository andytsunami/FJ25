package br.com.caelum.financas.util;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;

public class TesteAberturaConexoes {
	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			EntityManager em = new JPAUtil().getEntityManager();
			em.getTransaction().begin();
			System.out.println("Criado EntityManager de numero " + i);

		}
		try {
			Thread.sleep(30 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
