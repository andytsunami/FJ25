package br.com.caelum.financas.util;

import javax.persistence.Persistence;

public class CriaEntityManagerFactoryParaAtualizarBanco {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("controlefinancas");
	}

}
