package br.com.caelum.financas.modelo;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;

public class TesteCacheSegundoNivel {
	public static void main(String[] args) {
		EntityManager primeiraEm = new JPAUtil().getEntityManager();
		primeiraEm.getTransaction().begin();
		Conta primeiraConta = primeiraEm.find(Conta.class, 9);
		primeiraEm.getTransaction().commit();
		primeiraEm.close();

		EntityManager segundaEm = new JPAUtil().getEntityManager();
		Conta segundaConta = segundaEm.find(Conta.class, 9);
		segundaEm.close();

		System.out.println("Titular da primeira conta " + primeiraConta.getTitular());
		System.out.println("Titular da segunda conta " + segundaConta.getTitular());

		if (primeiraConta == segundaConta) {
			System.out.println("São iguais manolo!");
		} else {
			System.out.println("São diferente jão!!");
		}
	}
}
