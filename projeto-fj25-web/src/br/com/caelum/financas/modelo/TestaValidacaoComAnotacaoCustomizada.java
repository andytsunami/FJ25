package br.com.caelum.financas.modelo;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import br.com.caelum.financas.infra.ValidatorUtil;

public class TestaValidacaoComAnotacaoCustomizada {
	public static void main(String[] args) {
		Validator validator = new ValidatorUtil().getValidator();
		Conta conta = new Conta();
		conta.setAgencia("Uma agencia quq");
		Set<ConstraintViolation<Conta>> erros = validator.validate(conta);
		for (ConstraintViolation<Conta> erro : erros) {
			System.out.println(erro.getMessage());
		}

	}
}
