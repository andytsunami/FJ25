package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import br.com.caelum.financas.infra.ValidatorUtil;
import br.com.caelum.financas.modelo.Movimentacao;

public class TestaValidacaoValorMovimentacao {
	public static void main(String[] args) {
		Validator validator = new ValidatorUtil().getValidator();
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setValor(new BigDecimal("-1.0"));
		Set<ConstraintViolation<Movimentacao>> erros = validator.validate(movimentacao);
		for (ConstraintViolation<Movimentacao> erro : erros) {
			System.out.println(erro.getPropertyPath() + " - " + erro.getMessage());
		}
	}
}
