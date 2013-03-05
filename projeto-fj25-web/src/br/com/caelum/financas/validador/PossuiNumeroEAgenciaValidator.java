package br.com.caelum.financas.validador;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.financas.modelo.Conta;

public class PossuiNumeroEAgenciaValidator implements ConstraintValidator<PossuiNumeroEAgencia, Conta> {

	@Override
	public void initialize(PossuiNumeroEAgencia anotacao) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(Conta conta, ConstraintValidatorContext contexto) {
		// TODO Auto-generated method stub
		if (conta == null) {
			return true;
		}
		return !(conta.getAgencia() == null ^ conta.getNumero() == null);
	}

}
